package ru.job4j.tracker;

public class FindByNameItems implements UserAction {
    @Override
    public int key() {
        return StartUI.getFINDNAME();
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = null;
        while (name == null) {
            name = input.ask("Введите имя: ");
        }
        Item[] array = tracker.findByName(name);
        for (Item counter : array) {
            System.out.println("----------- Имя: " + counter.getName() + "-----------");
            System.out.println("----------- decs: " + counter.getDecs() + "-----------");
            System.out.println("----------- time: " + counter.getTime() + "-----------");
            System.out.println("----------- ID: " + counter.getId() + "-----------");
        }
    }

    @Override
    public String info() {
        return "Find by name";
    }
}
