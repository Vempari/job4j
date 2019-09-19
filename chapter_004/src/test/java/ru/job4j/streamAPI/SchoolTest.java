package ru.job4j.streamAPI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchoolTest {
    @Test
    public void WhenScoreMoreThen0ButLessThen50 () {
        School school = new School();
        List<Student> list = new ArrayList<>();
        Predicate<Student> predicateA = x -> x.getScore() >= 0;
        Predicate<Student> predicateB = x -> x.getScore() <= 50;
        list.add(new Student(5));
        list.add(new Student(25));
        list.add(new Student(52));
        list.add(new Student(100));
        list.add(new Student(80));
        list.add(new Student(60));
        list.add(new Student(45));
        list.add(new Student(-45));
        List<Student> result = school.collect(list, predicateA.and(predicateB));
        assertThat(result.get(0).getScore(), is(5) );
    }
    @Test
    public void WhenScoreMoreThen50ButLessThen70 () {
        School school = new School();
        List<Student> list = new ArrayList<>();
        Predicate<Student> predicateA = x -> x.getScore() >= 50;
        Predicate<Student> predicateB = x -> x.getScore() <= 70;
        list.add(new Student(5));
        list.add(new Student(25));
        list.add(new Student(52));
        list.add(new Student(100));
        list.add(new Student(80));
        list.add(new Student(60));
        list.add(new Student(45));
        list.add(new Student(-45));
        List<Student> result = school.collect(list, predicateA.and(predicateB));
        assertThat(result.get(0).getScore(), is(52) );
    }
    @Test
    public void WhenScoreMoreThen70ButLessThen100 () {
        School school = new School();
        List<Student> list = new ArrayList<>();
        Predicate<Student> predicateA = x -> x.getScore() >= 70;
        Predicate<Student> predicateB = x -> x.getScore() <= 100;
        list.add(new Student(5));
        list.add(new Student(25));
        list.add(new Student(52));
        list.add(new Student(100));
        list.add(new Student(80));
        list.add(new Student(60));
        list.add(new Student(45));
        list.add(new Student(-45));
        List<Student> result = school.collect(list, predicateA.and(predicateB));
        assertThat(result.get(0).getScore(), is(100) );
    }

}
