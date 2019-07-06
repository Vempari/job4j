package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
//    @Test
//    public void testFindByName() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("test1","testDescription", 123L);
//        Item item1 = new Item("test1","testDescription1", 1234L);
//        Item item2 = new Item("test2","testDescription2", 1235L);
//        Item item3 = new Item("test1","testDescription3", 1236L);
//        tracker.add(item);
//        tracker.add(item1);
//        tracker.add(item2);
//        tracker.add(item3);
//        Item[] result = tracker.findByName(item.getName());
//        assertThat(result.length, is(3));
//    }
    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item item1 = new Item("test2","testDescription1",created);
        tracker.add(item1);
        Item[] result = tracker.findAll();
        assertThat(result.length, is(2));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteNameThenReturn() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        tracker.add(next);
        next.setId(previous.getId());
        tracker.delete(previous.getId());
        assertThat(tracker.findById(next.getId()).getName(), is("test1"));
    }


}