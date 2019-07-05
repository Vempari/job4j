package ru.job4j.professions;

public class Programmer extends Engineer {


    public Programmer(String name, String surname, String education, int age) {
        super(name, surname, education, age);
    }

    @Override
    protected String createProject() {
        return null; //Блок-схема
    }
}
