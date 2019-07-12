package ru.job4j.tracker;

public class UpdateItem implements UserAction {
    @Override
    public int key() {
        return StartUI.getEDIT();
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки которую хотите изменить: ");
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123L);
        boolean answer = tracker.replace(id, item);
        if (answer) {
            System.out.println("-----------Операция прошла успешно-----------");
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        } else {
            System.out.println("-----------Произошла ошибка, попробуйте еще раз-----------");
        }
    }

    @Override
    public String info() {
        return "Edit item";
    }
}
