package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleStaticPrivate {
    private TrackerSingleStaticPrivate() {
    }

    public static TrackerSingleStaticPrivate getInstance() {
        return Holder.INSTANCE2;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleStaticPrivate INSTANCE2 = new TrackerSingleStaticPrivate();
    }

    public static void main(String[] args) {
        TrackerSingleStaticPrivate tracker = TrackerSingleStaticPrivate.getInstance();
    }
}