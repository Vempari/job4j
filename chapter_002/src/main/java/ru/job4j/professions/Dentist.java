package ru.job4j.professions;

public class Dentist extends Doctor {


    public Dentist(String name, String surname, String education, int age) {
        super(name, surname, education, age);
    }

    @Override
    protected String diagnose() {
        return null; // стомотологический диагноз
    }
}
