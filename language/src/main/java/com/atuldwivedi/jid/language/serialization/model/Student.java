package com.atuldwivedi.jid.language.serialization.model;

import java.io.Serializable;

public class Student implements Serializable {
    public transient long rollNumber;

    public static String section;

    public static int age;

    public String name;

    public Student(long rollNumber, String name, String section, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        Student.section = section;
        Student.age = age;
    }

    public void printDate() {
        System.out.println("Roll number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Section: " + section);
        System.out.println("Age: " + age);
    }
}
