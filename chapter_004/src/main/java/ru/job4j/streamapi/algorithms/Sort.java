package ru.job4j.streamapi.algorithms;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,2,5,3,9,8};
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > result[i]) {
                    counter = j;
                    result[i] = arr[j];
                }
            }
            arr[counter] = 0;
        }


        for (int counter : result) {
            System.out.print(counter);
        }
    }

}
