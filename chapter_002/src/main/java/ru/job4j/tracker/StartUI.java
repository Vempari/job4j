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
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.tracker.findAll();
            } else if (EDIT.equals(answer)) {
                //id коппируется методом replace.
                String id = this.input.ask("Введите ID заявки которую хотите изменить: ");
                System.out.println("------------ Добавление новой заявки --------------");
                String name = this.input.ask("Введите имя заявки :");
                String desc = this.input.ask("Введите описание заявки :");
                Item item = new Item(name, desc, 123L);
                this.tracker.replace(id, item);
            } else if (DELEATE.equals(answer)) {
                String id = this.input.ask("Введите ID: ");
                this.tracker.delete(id);
            } else if (FINDID.equals(answer)) {
                String id = this.input.ask("Введите ID: ");
                this.tracker.findById(id);
            } else if (FINDNAME.equals(answer)) {
                String name = this.input.ask("Введите имя: ");
                this.tracker.findByName(name);
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