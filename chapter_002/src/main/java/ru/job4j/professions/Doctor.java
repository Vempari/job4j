package ru.job4j.professions;

public class Doctor extends Profession {


    public Doctor(String name, String surname, String education, int age) {
        super(name, surname, education, age);
    }

    protected String diagnose() {
        return null; //Вы больны
    }
}
