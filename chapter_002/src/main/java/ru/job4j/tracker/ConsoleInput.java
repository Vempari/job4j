package ru.job4j.tracker;

import java.util.Scanner;


public class ConsoleInput {
    public String ask(String ask) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ask);
        return sc.nextLine();
    }
}
