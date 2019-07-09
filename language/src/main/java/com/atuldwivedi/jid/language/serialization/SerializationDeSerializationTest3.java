package com.atuldwivedi.jid.language.serialization;

import com.atuldwivedi.jid.language.serialization.model.Car;

import java.io.*;

public class SerializationDeSerializationTest3 {
    public static void main(String[] args) {
        String fileName = "serialization-deserialization.sd";
        Car car = new Car(1001, "Atul");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(car);

            System.out.println("Before deserialization: ");
            car.printDate();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Car deSerializedCar = (Car) objectInputStream.readObject();
            System.out.println("After deserialization: ");
            deSerializedCar.printDate();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
