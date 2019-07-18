package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleStatic {
    private static TrackerSingleStatic instance;

    private TrackerSingleStatic() {
    }

    public static TrackerSingleStatic getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStatic();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}