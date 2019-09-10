package com.atuldwivedi.jid.language.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Reader {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File("object.out"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee employee = (Employee) ois.readObject();
        System.out.println(employee);
    }
}
