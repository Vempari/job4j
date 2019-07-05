package ru.job4j.professions;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public Profession(String name, String surname, String education, int age) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.age = age;
    }
}
