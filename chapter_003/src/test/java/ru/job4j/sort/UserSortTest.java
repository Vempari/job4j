package ru.job4j.sort;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserSortTest {
    @Test
    public void treeSetSort() {
        UserSort sort = new UserSort();
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(22, "Vasya"));
        list.add(new User(19, "Masha"));
        list.add(new User(65, "Katya"));
        list.add(new User(1, "Anya"));
        TreeSet<User> result = sort.sortSet(list);
        assertThat(result.first().getName(), is("Anya"));
    }
}
