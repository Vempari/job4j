package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleStaticFinal {
    private static final TrackerSingleStaticFinal INSTANCE1 = new TrackerSingleStaticFinal();

    private TrackerSingleStaticFinal() {
    }

    public static TrackerSingleStaticFinal getInstance() {
        return INSTANCE1;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleStaticFinal tracker = TrackerSingleStaticFinal.getInstance();
    }
}
