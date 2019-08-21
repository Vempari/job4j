package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.function.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    private static final String MENU =
        "0 : Add new Item" + System.lineSeparator() + "1 : Show all items" + System.lineSeparator() + "2 : Edit item" + System.lineSeparator() + "3 : Delete item" + System.lineSeparator() + "4 : Find items by Id" + System.lineSeparator() + "5 : Find by name" + System.lineSeparator() + "6 : Exit Program" + System.lineSeparator();

    @Test
    public void whenUserAddItemThenDeleteItTrackerDoesntHaveIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.delete(item.getId()), is(false));
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
        new StartUI(input, tracker, output).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------" + System.lineSeparator())
                                .append("----------- decs: " + item.getDecs() + "-----------" + System.lineSeparator())
                                .append("----------- time: " + item.getTime() + "-----------" + System.lineSeparator())
                                .append("----------- ID: " + item.getId() + "-----------" + System.lineSeparator())
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
        new StartUI(input, tracker, output).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------" + System.lineSeparator())
                                .append("----------- decs: " + item.getDecs() + "-----------" + System.lineSeparator())
                                .append("----------- time: " + item.getTime() + "-----------" + System.lineSeparator())
                                .append("----------- ID: " + item.getId() + "-----------" + System.lineSeparator())
                                .toString()
                ));
    }

    @Test
    public void whenUserFindAllPrintAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name33", "desc", 12L));
        ConsoleInput input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("----------- Имя: " + item.getName() + "-----------" + System.lineSeparator())
                                .append("----------- decs: " + item.getDecs() + "-----------" + System.lineSeparator())
                                .append("----------- time: " + item.getTime() + "-----------" + System.lineSeparator())
                                .append("----------- ID: " + item.getId() + "-----------" + System.lineSeparator())
                                .toString()
                ));
    }

}
