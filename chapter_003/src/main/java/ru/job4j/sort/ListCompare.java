package ru.job4j.sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        if (left.equals(right)) {
            return result;
        }
        else {
            char[] leftArray = left.toCharArray();
            char[] rightArray = right.toCharArray();
            int length = (leftArray.length > rightArray.length) ? leftArray.length : rightArray.length;
            try {
                for (int i = 0; i < length; i++) {
                    if (leftArray[i] > rightArray[i]) {
                        result = 1;
                        break;
                    }
                    else if (rightArray[i] > leftArray[i]) {
                        result = -1;
                        break;
                    }
                }
            } catch (Exception e) {
                return -1;
            }
        }
        return result;
    }
}