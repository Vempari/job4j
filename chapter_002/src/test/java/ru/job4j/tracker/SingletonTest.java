package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SingletonTest {
    @Test
    public void trackerSingleTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        assertThat(item, is(TrackerSingle.INSTANCE.add(item)));
    }
    @Test
    public void trackerSingleStaticTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        TrackerSingleStatic tracker = TrackerSingleStatic.getInstance();
        assertThat(item, is(tracker.add(item)));
    }
    @Test
    public void trackerSingleStaticFinalTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        assertThat(item, is(TrackerSingleStaticFinal.getInstance().add(item)));
    }
    @Test
    public void trackerSingleStaticPrivateTest() {
        Item item = new Item("Test name", "Test decs", 123L);
        assertThat(item, is(TrackerSingleStaticPrivate.getInstance().add(item)));
    }
}
