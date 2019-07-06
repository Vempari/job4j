package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Date;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

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
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i, this.items, 0, this.items.length - i);
                return true;
            }
        }
        return false;
    }

    public Item[] findAll() {
        ArrayList result = new ArrayList();
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                result.add(this.items[i]);
            }
        }
        return (Item[]) result.toArray(new Item[result.size()]);
    }

    public Item[] findByName(String key) {
        ArrayList result = new ArrayList();
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                result.add(this.items[i]);
            }
        }
        return (Item[]) result.toArray(new Item[result.size()]);
    }

    public Item findById(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                return this.items[i];
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