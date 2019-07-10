package com.atuldwivedi.jid.language.immutability;

public class ImmutabilityTest1 {
    public static void main(String[] args) {
        Employee1 immutableStudent = new Employee1(1001l, "Atul");
        System.out.println(immutableStudent);
    }
}

final class Employee1 {
    private final long id;

    private final String name;

    public Employee1(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


