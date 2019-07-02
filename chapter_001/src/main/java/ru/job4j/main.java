package ru.job4j;

public class main {
    public static void calc(int value) {
        if (value != 0 && value / 0 >= 0) {
            System.out.println("div by zero");
        } else {
            System.out.println("zero by zero");
        }
    }
    public static void main(String[] args) {
        calc(0);
    }
}


