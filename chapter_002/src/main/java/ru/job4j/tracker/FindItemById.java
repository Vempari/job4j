package ru.job4j.tracker;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID: ");
        if (id != null) {
            Item item = tracker.findById(id);
            System.out.println("----------- Имя: " + item.getName() + "-----------");
            System.out.println("----------- decs: " + item.getDecs() + "-----------");
            System.out.println("----------- time: " + item.getTime() + "-----------");
            System.out.println("----------- ID: " + item.getId() + "-----------");
        } else {
            System.out.println("Нужно ввести существующий ID");
        }
    }
}
