package ru.job4j;

public class TestAsk {
    public int[] sort(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        int l = 0;
        int i = 0;
        int j = 0;
        while (l < a3.length) {
            if (i == a1.length) {
                a3[l] = a2[j];
                j++;
            } else if (j == a2.length) {
                a3[l] = a1[i];
                i++;
            } else if (a1[i] <= a2[j]) {
                a3[l] = a1[i];
                i++;
            } else {
                a3[l] = a2[j];
                j++;
            }
            l++;
            System.out.println("tK NU TUT BUDET HUY");
        }

        return a3;
    }
}
