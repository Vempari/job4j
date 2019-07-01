package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - count; j++) {
                if (array[i].equals(array[j])) {
                    String sub = array[j];
                    array[j] = array[array.length - 1 - count];
                    array[array.length - 1 - count] = sub;
                    count++;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, count + 1);
    }
}
