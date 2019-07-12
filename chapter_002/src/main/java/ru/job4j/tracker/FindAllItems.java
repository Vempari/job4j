package ru.job4j.tracker;

public class FindAllItems implements UserAction {
    @Override
    public int key() {
        return StartUI.getSHOW();
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] array = tracker.findAll();
        for (Item counter : array) {
            System.out.println("----------- Имя: " + counter.getName() + "-----------");
            System.out.println("----------- decs: " + counter.getDecs() + "-----------");
            System.out.println("----------- time: " + counter.getTime() + "-----------");
            System.out.println("----------- ID: " + counter.getId() + "-----------");
        }
    }

    @Override
    public String info() {
        return "Show all items";
    }
}
