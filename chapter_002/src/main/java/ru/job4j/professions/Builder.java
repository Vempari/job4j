package ru.job4j.professions;

public class Builder extends Engineer {


    public Builder(String name, String surname, String education, int age) {
        super(name, surname, education, age);
    }

    @Override
    protected String createProject() {
        return null; //Инженерный план дома
    }
}
