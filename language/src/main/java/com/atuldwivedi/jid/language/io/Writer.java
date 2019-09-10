package com.atuldwivedi.jid.language.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
    public static void main(String[] args) throws IOException {
        FileOutputStream fis = new FileOutputStream(new File("object.out"));
        ObjectOutputStream oos = new ObjectOutputStream(fis);
        Address1 address = new Address1();
        address.setStreet("One");
        address.getLandmark().add("Sai Temple");
        Employee employee = new Employee();
        employee.setName("Atul");
        employee.setAge(22);
        employee.setAddress(address);
        oos.writeObject(employee);
        oos.reset();
    }
}
