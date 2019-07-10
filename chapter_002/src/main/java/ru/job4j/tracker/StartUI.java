package ru.job4j.tracker;
/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вовода на экран всех объектов.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования элемента.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления элемента.
     */
    private static final String DELEATE = "3";
    /**
     * Константа меню для поиска по ID.
     */
    private static final String FINDID = "4";
    /**
     * Константа меню для поиска по имени.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
                exit = true;
            } else if (SHOW.equals(answer)) {
                this.showAll();
                exit = true;
            } else if (EDIT.equals(answer)) {
                this.editItem();
                exit = true;
            } else if (DELEATE.equals(answer)) {
                this.deleteItem();
                exit = true;
            } else if (FINDID.equals(answer)) {
                this.findByID();
                exit = true;
            } else if (FINDNAME.equals(answer)) {
                this.findByName();
                exit = true;
            } else if (EXIT.equals(answer)) {
                System.out.println("Всего доброго!");
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    private void findByID() {
        String id = this.input.ask("Введите ID: ");
        Item item = this.tracker.findById(id);
        System.out.println("----------- Имя: " + item.getName() + "-----------");
        System.out.println("----------- decs: " + item.getDecs() + "-----------");
        System.out.println("----------- time: " + item.getTime() + "-----------");
        System.out.println("----------- ID: " + item.getId() + "-----------");
    }
    private void findByName() {
        String name = null;
        while (name == null) {
            name = this.input.ask("Введите имя: ");
        }
        Item[] array = this.tracker.findByName(name);
        for (Item counter : array) {
            System.out.println("----------- Имя: " + counter.getName() + "-----------");
            System.out.println("----------- decs: " + counter.getDecs() + "-----------");
            System.out.println("----------- time: " + counter.getTime() + "-----------");
            System.out.println("----------- ID: " + counter.getId() + "-----------");
        }
    }
    private void editItem() {
        String id = this.input.ask("Введите ID заявки которую хотите изменить: ");
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123L);
        boolean answer = this.tracker.replace(id, item);
        if (answer == true) {
            System.out.println("-----------Операция прошла успешно-----------");
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
        else {
            System.out.println("-----------Произошла ошибка, попробуйте еще раз-----------");
        }
    }

    private void deleteItem() {
        String id = this.input.ask("Введите ID: ");
        boolean answer = this.tracker.delete(id);
        if (answer == true) {
            System.out.println("-----------Операция прошла успешно-----------");
        }
        else {
            System.out.println("-----------Произошла ошибка, попробуйте еще раз-----------");
        }
    }

    private void showAll() {
        Item[] array = this.tracker.findAll();
        for (Item counter : array) {
            System.out.println("----------- Имя: " + counter.getName() + "-----------");
            System.out.println("----------- decs: " + counter.getDecs() + "-----------");
            System.out.println("----------- time: " + counter.getTime() + "-----------");
            System.out.println("----------- ID: " + counter.getId() + "-----------");
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}