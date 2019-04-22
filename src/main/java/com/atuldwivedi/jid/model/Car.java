package com.atuldwivedi.jid.model;

public class Car {

    private Long number;

    private String name;

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Car(Long number, String name) {
        this.number = number;
        this.name = name;
    }
}
