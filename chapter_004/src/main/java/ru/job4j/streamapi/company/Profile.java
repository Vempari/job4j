package ru.job4j.streamapi.company;

public class Profile {

    public Profile(Adress adress) {
        this.adress = adress;
    }

    private Adress adress;

    public Adress getAdress() {
        return adress;
    }
}
