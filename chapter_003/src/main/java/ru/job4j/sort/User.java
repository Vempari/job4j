package ru.job4j.sort;

public class User implements Comparable<User>{

    private Integer age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
