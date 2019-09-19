package ru.job4j.streamAPI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.*;



public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
