package com.atuldwivedi.jid.language.model;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private Long rollNumber;

    private String name;

    public Student(Long rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return this.rollNumber.compareTo(otherStudent.rollNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(rollNumber, student.rollNumber) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber, name);
    }
}
