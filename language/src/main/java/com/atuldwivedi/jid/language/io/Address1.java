package com.atuldwivedi.jid.language.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Address1 implements Serializable {
    private static final long serialVersionUID = 8573166407963026249L;
    private String street;


    public void setStreet(String street) {
        this.street = street;
    }

    private List<String> landmark = new ArrayList<>();

    public Address1() {

    }

    public String getStreet() {
        return street;
    }

    public List<String> getLandmark() {
        return landmark;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", landmark=" + landmark +
                '}';
    }

    public void setLandmark(List<String> landmark) {
        this.landmark = landmark;
    }
}
