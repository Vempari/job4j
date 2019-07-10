package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        ConsoleInput input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 12L));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        ConsoleInput input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserAddItemThenDeleteItTrackerDoesntHaveIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"3", item.getId()});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[0]));
    }
    @Test
    public void whenUserFindIdThenFindId() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name", "desc", 12L));
        tracker.add(new Item("test name2", "desc", 12L));
        tracker.add(new Item("test name3", "desc", 12L));
        Item item = tracker.add(new Item("test name", "desc", 12L));
        tracker.add(new Item("test name222", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"4", item.getId()});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    @Test
    public void whenUserAddItemThenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name33", "desc", 12L));
        tracker.add(new Item("test name1", "desc", 12L));
        tracker.add(new Item("test name2", "desc", 12L));
        tracker.add(new Item("test name3", "desc", 12L));
        tracker.add(new Item("test name4", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"5", item.getName()});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name33"));
    }
    @Test
    public void whenUserFindAllPrintAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name33", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"1"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню.\n")
                                .append("0. Add new Item\n")
                                .append("1. Show all items\n")
                                .append("2. Edit item\n")
                                .append("3. Delete item\n")
                                .append("4. Find item by Id\n")
                                .append("5. Find items by name\n")
                                .append("6. Exit Program\n")
                                .append("----------- Имя: test name33-----------\n")
                                .append("----------- decs: desc-----------\n")
                                .append("----------- time: 12-----------\n")
                                .append("----------- ID: " + item.getId() + "-----------\n")
                                .toString()
                ));
    }

}
