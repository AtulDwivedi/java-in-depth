package com.atuldwivedi.jid.language.serialization.model;

import java.io.Serializable;

public class Person implements Serializable {
    public String name;

    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}