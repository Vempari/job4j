package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }
    /**
     * Метод заменяет элемент в массиве, находя его по ID.
     */
    public boolean replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (items.get(i).getId().equals(id)) {
                items.add(i, item);
                item.setId(id);
                return true;
            }
        }
        return false;
    }
    /**
     * Метод удаляет элемент.
     */
    public boolean delete(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }
    /**
     * Метод находит все существующие объекты в массиве. Возвращает новый массив состоящий только из этих элементов.
     */
    public ArrayList<Item> findAll() {
        return items;
    }
    /**
     * Метод находит все элементы с одинаковым полем Name. Возвращает массив состоящий из этих элементов.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }
    /**
     * Метод находит элемент в массиве по ID.
     */
    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Date date = new Date();
        return date.toString() + Math.random();
    }
}