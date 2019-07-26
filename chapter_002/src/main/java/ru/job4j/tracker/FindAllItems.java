package ru.job4j.tracker;

import java.util.ArrayList;

public class FindAllItems extends BaseAction {

    public FindAllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        ArrayList<Item> array = tracker.findAll();
        for (Item counter : array) {
            System.out.println("----------- Имя: " + counter.getName() + "-----------");
            System.out.println("----------- decs: " + counter.getDecs() + "-----------");
            System.out.println("----------- time: " + counter.getTime() + "-----------");
            System.out.println("----------- ID: " + counter.getId() + "-----------");
        }
    }
}
