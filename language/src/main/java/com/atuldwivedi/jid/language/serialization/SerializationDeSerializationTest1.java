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
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person deSerializedPerson = (Person) objectInputStream.readObject();
            System.out.println(deSerializedPerson.age);
            System.out.println(deSerializedPerson.name);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
