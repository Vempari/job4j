package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.*;



public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    Map<String, Student> map(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e
                ));
    }

}
