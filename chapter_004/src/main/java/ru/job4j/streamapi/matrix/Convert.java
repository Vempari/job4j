package ru.job4j.streamapi.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.function.*;


public class Convert {
    List<Integer> convert(Integer[][] matrix){
        return Stream.of(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
