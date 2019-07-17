package ru.job4j.tracker;

import java.util.*;
/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    public static int getADD() {
        return ADD;
    }

    public static int getSHOW() {
        return SHOW;
    }

    public static int getEDIT() {
        return EDIT;
    }

    public static int getDELEATE() {
        return DELEATE;
    }

    public static int getFINDID() {
        return FINDID;
    }

    public static int getFINDNAME() {
        return FINDNAME;
    }

    public static int getEXIT() {
        return EXIT;
    }

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;
    /**
     * Константа меню для вовода на экран всех объектов.
     */
    private static final int SHOW = 1;
    /**
     * Константа меню для редактирования элемента.
     */
    private static final int EDIT = 2;
    /**
     * Константа меню для удаления элемента.
     */
    private static final int DELEATE = 3;
    /**
     * Константа меню для поиска по ID.
     */
    private static final int FINDID = 4;
    /**
     * Константа меню для поиска по имени.
     */
    private static final int FINDNAME = 5;
    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        int[] arr = range.stream().mapToInt(i -> i).toArray();
        do {
            menu.show();
            menu.select(input.ask("select:", arr));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}