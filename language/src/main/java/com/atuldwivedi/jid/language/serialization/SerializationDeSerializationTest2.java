package com.atuldwivedi.jid.language.serialization;

import com.atuldwivedi.jid.language.serialization.model.Student;

import java.io.*;

public class SerializationDeSerializationTest2 {
    public static void main(String[] args) {
        Student student = new Student(101l, "Atul", "B", 22);
        String fileName = "serialization-deserialization.sd";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);

            System.out.println("Before deserialization: ");
            student.printDate();

            Student.age = 25;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student deSerializedStudent = (Student) objectInputStream.readObject();

            System.out.println("After deserialization: ");
            deSerializedStudent.printDate();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
