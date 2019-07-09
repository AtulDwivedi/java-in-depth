package com.atuldwivedi.jid.language.serialization.model;

import java.io.Serializable;

public class Laptop extends Device implements Serializable {
    String name;

    public Laptop(int number, String name) {
        super(number);
        this.name = name;
    }
}
