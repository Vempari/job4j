package ru.job4j.tracker;

import java.util.Arrays;
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
    /**
     * Метод заменяет элемент в массиве, находя его по ID.
     */
    public boolean replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                return true;
            }
        }
        return false;
    }
    /**
     * Метод удаляет элемент.
     */
    public boolean delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, 1);
                position--;
                return true;
            }
        }
        return false;
    }
    /**
     * Метод находит все существующие объекты в массиве. Возвращает новый массив состоящий только из этих элементов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * Метод находит все элементы с одинаковым полем Name. Возвращает массив состоящий из этих элементов.
     */
    public Item[] findByName(String key) {
        Item[] res = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                res[count] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(res, count);
    }
    /**
     * Метод находит элемент в массиве по ID.
     */
    public Item findById(String id) {
        for (int i = 0; i < this.position; i++) {
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