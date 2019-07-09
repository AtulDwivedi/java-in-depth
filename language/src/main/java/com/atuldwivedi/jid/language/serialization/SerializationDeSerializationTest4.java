package com.atuldwivedi.jid.language.serialization;

import com.atuldwivedi.jid.language.serialization.model.Laptop;

import java.io.*;

public class SerializationDeSerializationTest4 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(101, "MacBook Pro");
        String fileName = "serialization-deserialization.sd";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(laptop);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Laptop deSerializedLaptop = (Laptop) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
