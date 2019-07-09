package com.atuldwivedi.jid.language.serialization.model;

public class Car extends Vehicle {
    String name;

    public Car(int number, String name) {
        super(number);
        this.name = name;
    }

    public void printDate() {
        System.out.println("Car number: " + number);
        System.out.println("Car name: " + name);
    }
}
