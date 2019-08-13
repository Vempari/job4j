package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<Task>();


    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public boolean put(Task task) {
        if (tasks.size() == 0) {
            this.tasks.add(task);
            return true;
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                this.tasks.add(i, task);
                return true;
            }
        }
        this.tasks.add(task);
        return true;
    }

    public Task take() {
        return this.tasks.poll();
    }
}