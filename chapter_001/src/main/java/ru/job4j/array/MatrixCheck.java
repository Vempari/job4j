package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != data[i - 1][i - 1]) {
                return false;
            }
        }
        return true;
    }
}