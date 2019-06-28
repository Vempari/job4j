package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int smt;
        int len = array.length - 1;
        for (int i = 0; i <= len / 2; i++) {
            smt = array[i];
            array[i] = array[len - i];
            array[len - i] = smt;
        }
        return array;
    }
}