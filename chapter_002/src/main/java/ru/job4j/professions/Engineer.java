package ru.job4j.professions;

public class Engineer extends Profession {


    public Engineer(String name, String surname, String education, int age) {
        super(name, surname, education, age);
    }

    protected String createProject() {
        return null;
    }
}
