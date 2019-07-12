package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return StartUI.getDELEATE();
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID: ");
        boolean answer = tracker.delete(id);
        if (answer) {
            System.out.println("-----------Операция прошла успешно-----------");
        } else {
            System.out.println("-----------Произошла ошибка, попробуйте еще раз-----------");
        }
    }

    @Override
    public String info() {
        return "Delete item";
    }
}
