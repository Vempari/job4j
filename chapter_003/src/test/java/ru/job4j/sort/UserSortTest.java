package ru.job4j.sort;
import org.junit.Test;

import java.util.*;
import java.util.stream.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserSortTest {
    @Test
    public void treeSetSort() {
        UserSort sort = new UserSort();
        List<User> list = List.of(
                new User(22, "Vasya"),
                new User(19, "Masha"),
                new User(65, "Katya"),
                new User(1, "Anya")
        );
        TreeSet<User> result = sort.sortSet(list);
        assertThat(result.first().getName(), is("Anya"));
    }
    @Test
    public void nameLengthSort() {
        UserSort sort = new UserSort();
        List<User> list = List.of(
                new User(22, "Vasya33"),
                new User(19, "Masha22"),
                new User(65, "Anyaaa"),
                new User(1, "Anya")
        );
        List<User> result = sort.sortNameLength(list);
        assertThat(result.get(0).getName(), is("Anya"));
    }
    @Test
    public void nameAllSort() {
        UserSort sort = new UserSort();
        List<User> list = List.of(
                new User(22, "Vasya33"),
                new User(19, "Masha22"),
                new User(65, "Anyaaa"),
                new User(77, "Anya")
        );
        List<User> result = sort.sortByAllFields(list);
        assertThat(result.get(0).getAge(), is(77));
    }
}
