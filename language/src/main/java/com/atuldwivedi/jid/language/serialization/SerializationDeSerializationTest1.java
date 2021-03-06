package com.atuldwivedi.jid.language.serialization;

import com.atuldwivedi.jid.language.serialization.model.Person;

import java.io.*;

public class SerializationDeSerializationTest1 {
    public static void main(String[] args) {
        String fileName = "serialization-deserialization.sd";
        Person person = new Person("Atul", 22);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);

            System.out.println("Before deserialization: \n" + person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person deSerializedPerson = (Person) objectInputStream.readObject();
            System.out.println("After deserialization: \n" + deSerializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
