package com.atuldwivedi.jid.language.serialization;

import com.atuldwivedi.jid.language.serialization.model.Lion;

import java.io.*;

public class SerializationDeSerializationTest5 {
    public static void main(String[] args) {
        Lion lion = new Lion(10, "Roar");
        String fileName = "serialization-deserialization.sd";

        //serialization
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lion);
            System.out.println("Before deserialization: " + lion);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        //deserialization
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Lion deSerializedLion = (Lion) objectInputStream.readObject();
            System.out.println("After deserialization: " + deSerializedLion);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
