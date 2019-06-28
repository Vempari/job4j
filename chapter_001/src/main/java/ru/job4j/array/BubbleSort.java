package ru.job4j.array;

public class BubbleSort {
    public int[] bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int sub = array[i];
                    array[i] = array[j];
                    array[j] = sub;
                }
            }
        }
        return array;
    }
}
