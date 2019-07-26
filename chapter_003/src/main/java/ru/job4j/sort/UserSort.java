package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {

    public TreeSet<User> sortSet(List<User> list) {
        TreeSet<User> UserSet = new TreeSet<>(Comparator.comparing(User::getAge));
        UserSet.addAll(list);
        return UserSet;
    }

}
