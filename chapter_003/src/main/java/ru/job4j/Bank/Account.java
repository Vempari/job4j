package ru.job4j.Bank;

import java.util.Objects;

public class Account {
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private double value;
    private String requisites;

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return value == account.value &&
                requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }
}
