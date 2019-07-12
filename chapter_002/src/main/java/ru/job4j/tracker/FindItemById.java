package ru.job4j.tracker;

public class FindItemById implements UserAction {

    @Override
    public int key() {
        return StartUI.getFINDID();
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

    @Override
    public String info() {
        return "Find items by Id";
    }
}
