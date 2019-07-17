package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String name) {
        super(key, name);
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
}
