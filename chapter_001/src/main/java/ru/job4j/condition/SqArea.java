package ru.job4j.condition;

public class SqArea {
    public int square(int p, int k) {
        int w = p * k / (2 * (k + 1));
        int h = w / k;
        return w * h;
    }
}
