package ru.job4j.streamapi;

public class Student {
    int score;
    String surname;


    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }
}
