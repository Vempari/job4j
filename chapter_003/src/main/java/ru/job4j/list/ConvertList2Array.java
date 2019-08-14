package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() % rows == 0) ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer counter : list) {
            array [i][j] = counter;
            if (counter % rows == 0) {
                i++;
                j = -1;
            }
            j++;

        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> convertedList = new ArrayList<>();
        for (int[] counter : list) {
            for (int inner : counter) {
                convertedList.add(inner);
            }
        }
        return convertedList;
    }


}