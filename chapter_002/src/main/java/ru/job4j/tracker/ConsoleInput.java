package ru.job4j.tracker;

import java.util.Scanner;


public class ConsoleInput implements Input {
    @Override
    public String ask(String ask) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ask);
        return sc.nextLine();
    }
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = true;
        for (int value : range) {
            if (value == key) {
                exist = false;
                break;
            }
        }
        if (!exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range. ");
        }
    }
}
