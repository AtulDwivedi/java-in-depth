package com.atuldwivedi.jid.language.serialization;

import com.atuldwivedi.jid.language.serialization.model.Parrot;

import java.io.*;

public class SerializationDeSerializationTest6 {
    public static void main(String[] args) {
        Parrot parrot = new Parrot(10, "Talk");
        String fileName = "serialization-deserialization.sd";

        //serialization
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(parrot);
            System.out.println("Before deserialization: " + parrot);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //deserialization
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Parrot deSerializedParrot = (Parrot) objectInputStream.readObject();
            System.out.println("After deserialization: " + deSerializedParrot);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
