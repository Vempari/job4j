package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SingletonTest {
    @Test
    public void TrackerSingleTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        assertThat(item, is(TrackerSingle.INSTANCE.add(item)));
    }
    @Test
    public void TrackerSingleStaticTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        TrackerSingleStatic tracker = TrackerSingleStatic.getInstance();
        assertThat(item, is(tracker.add(item)));
    }
    @Test
    public void TrackerSingleStaticFinalTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        assertThat(item, is(TrackerSingleStaticFinal.getInstance().add(item)));
    }
    @Test
    public void TrackerSingleStaticPrivateTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        assertThat(item, is(TrackerSingleStaticPrivate.getInstance().add(item)));
    }
}
