package ru.job4j.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchoolTest {
    @Test
    public void whenScoreMoreThenZeroButLessThenFifty() {
        School school = new School();
        List<Student> list = new ArrayList<>();
        Predicate<Student> predicateA = x -> x.getScore() >= 0;
        Predicate<Student> predicateB = x -> x.getScore() <= 50;
        list.add(new Student(5, "Vasin"));
        list.add(new Student(25, "Vasin"));
        list.add(new Student(52, "Vasin"));
        list.add(new Student(100, "Vasin"));
        list.add(new Student(80, "Vasin"));
        list.add(new Student(60, "Vasin"));
        list.add(new Student(45, "Vasin"));
        list.add(new Student(-45, "Vasin"));
        List<Student> result = school.collect(list, predicateA.and(predicateB));
        assertThat(result.get(0).getScore(), is(5));
    }
    @Test
    public void whenScoreMoreThenFiftyButLessThenSeventy() {
        School school = new School();
        List<Student> list = new ArrayList<>();
        Predicate<Student> predicateA = x -> x.getScore() >= 50;
        Predicate<Student> predicateB = x -> x.getScore() <= 70;
        list.add(new Student(5, "Vasin"));
        list.add(new Student(25, "Vasin"));
        list.add(new Student(52, "Vasin"));
        list.add(new Student(100, "Vasin"));
        list.add(new Student(80, "Vasin"));
        list.add(new Student(60, "Vasin"));
        list.add(new Student(45, "Vasin"));
        list.add(new Student(-45, "Vasin"));
        List<Student> result = school.collect(list, predicateA.and(predicateB));
        assertThat(result.get(0).getScore(), is(52));
    }
    @Test
    public void whenScoreMoreThenSeventyButLessThenHundred() {
        School school = new School();
        List<Student> list = new ArrayList<>();
        Predicate<Student> predicateA = x -> x.getScore() >= 70;
        Predicate<Student> predicateB = x -> x.getScore() <= 100;
        list.add(new Student(5, "Vasin"));
        list.add(new Student(25, "Vasin"));
        list.add(new Student(52, "Vasin"));
        list.add(new Student(100, "Vasin"));
        list.add(new Student(80, "Vasin"));
        list.add(new Student(60, "Vasin"));
        list.add(new Student(45, "Vasin"));
        list.add(new Student(-45, "Vasin"));
        List<Student> result = school.collect(list, predicateA.and(predicateB));
        assertThat(result.get(0).getScore(), is(100));
    }
    @Test
    public void whenListToMap() {
        School school = new School();
        List<Student> list = new ArrayList<>();
        Predicate<Student> predicateA = x -> x.getScore() >= 70;
        Predicate<Student> predicateB = x -> x.getScore() <= 100;
        list.add(new Student(5, "Jhonson"));
        list.add(new Student(25, "Vasin"));
        list.add(new Student(52, "Smith"));
        list.add(new Student(100, "Kelly"));
        list.add(new Student(80, "Kokorin"));
        Map<String, Student> result = school.map(list);
        assertThat(result.get("Smith").getScore(), is(52));
    }

}
