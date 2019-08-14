package ru.job4j.sort;

import java.util.*;

public class UserSort {

    public TreeSet<User> sortSet(List<User> list) {
        TreeSet<User> userSet = new TreeSet<>();
        userSet.addAll(list);
        return userSet;
    }

    public List<User> sortNameLength(List<User> list) {
        List<User> users = new ArrayList<>();
        users.addAll(list);
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        Integer length1 = o1.getName().length();
                        Integer length2 = o2.getName().length();
                        return length1.compareTo(length2);
                    }
                }
        );
        return users;
    }

    public List<User> sortByAllFields(List<User> list) {
        List<User> users = new ArrayList<>();
        users.addAll(list);
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
                .thenComparing(
                        new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                Integer age1 = o1.getAge();
                                Integer age2 = o2.getAge();
                                return age1.compareTo(age2);
                            }
                        }
                )
        );
        return users;
    }
}
