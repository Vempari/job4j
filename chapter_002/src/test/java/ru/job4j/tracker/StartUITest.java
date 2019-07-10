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
    private static final String MENU =
        "Меню.\r\n0. Add new Item\r\n1. Show all items\r\n2. Edit item\r\n3. Delete item\r\n4. Find item by Id\r\n5. Find items by name\r\n6. Exit Program\r\n";

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
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------\r\n")
                                .append("----------- decs: " + item.getDecs() + "-----------\r\n")
                                .append("----------- time: " + item.getTime() + "-----------\r\n")
                                .append("----------- ID: " + item.getId() + "-----------\r\n")
                                .toString()
                ));
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
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------\r\n")
                                .append("----------- decs: " + item.getDecs() + "-----------\r\n")
                                .append("----------- time: " + item.getTime() + "-----------\r\n")
                                .append("----------- ID: " + item.getId() + "-----------\r\n")
                                .toString()
                ));
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
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------\r\n")
                                .append("----------- decs: " + item.getDecs() + "-----------\r\n")
                                .append("----------- time: " + item.getTime() + "-----------\r\n")
                                .append("----------- ID: " + item.getId() + "-----------\r\n")
                                .toString()
                ));
    }

}
