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
        "0. Add new Item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find items by Id\n5. Find by name\n6. Exit Program\n";

    @Test
    public void whenUserAddItemThenDeleteItTrackerDoesntHaveIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"3", item.getId(), "y"});
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
        ConsoleInput input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------\n")
                                .append("----------- decs: " + item.getDecs() + "-----------\n")
                                .append("----------- time: " + item.getTime() + "-----------\n")
                                .append("----------- ID: " + item.getId() + "-----------\n")
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
        ConsoleInput input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------\n")
                                .append("----------- decs: " + item.getDecs() + "-----------\n")
                                .append("----------- time: " + item.getTime() + "-----------\n")
                                .append("----------- ID: " + item.getId() + "-----------\n")
                                .toString()
                ));
    }

    @Test
    public void whenUserFindAllPrintAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name33", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------\n")
                                .append("----------- decs: " + item.getDecs() + "-----------\n")
                                .append("----------- time: " + item.getTime() + "-----------\n")
                                .append("----------- ID: " + item.getId() + "-----------\n")
                                .toString()
                ));
    }

}
