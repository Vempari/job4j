package ru.job4j.tracker;

public class Exit implements UserAction {
    @Override
    public int key() {
        return StartUI.getEXIT();
    }

    @Override
    public void execute(Input input, Tracker tracker) {
    }

    @Override
    public String info() {
        return "Exit Program";
    }
}
