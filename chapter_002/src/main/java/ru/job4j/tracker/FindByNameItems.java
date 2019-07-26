package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByNameItems extends BaseAction {
    protected FindByNameItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = null;
        while (name == null) {
            name = input.ask("Введите имя: ");
        }
        ArrayList<Item> array = tracker.findByName(name);
        for (Item counter : array) {
            System.out.println("----------- Имя: " + counter.getName() + "-----------");
            System.out.println("----------- decs: " + counter.getDecs() + "-----------");
            System.out.println("----------- time: " + counter.getTime() + "-----------");
            System.out.println("----------- ID: " + counter.getId() + "-----------");
        }
    }
}
