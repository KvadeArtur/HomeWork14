package com.kvart;

public class Persons {

    private String surname;
    private String name;

    public Persons(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Persons(String fullName) {
        String[] full = fullName.split("\\s+");
        this.surname = full[1];
        this.name = full[0];
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
