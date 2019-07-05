package ru.job4j.professions;

 class Surgeon extends Doctor {


     public Surgeon(String name, String surname, String education, int age) {
        super(name, surname, education, age);
    }

    @Override
    protected String diagnose() {
        return null; // хирургический диагноз
    }
    protected String operation() {
        return null;
    }
}
