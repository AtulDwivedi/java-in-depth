package com.atuldwivedi.jid.language.immutability;

public class ImmutabilityTest5Problem2Solution {
    public static void main(String[] args) {
        Address5 address = new Address5("Bangalore", "India");
        Employee5 immutableEmployee = new Employee5(1001l, "Atul", address);
        System.out.println("Before: " + immutableEmployee);
        immutableEmployee.getAddress().setCity("New York");
        System.out.println("After: " + immutableEmployee);
    }
}

final class Employee5 {
    private final long id;

    private final String name;

    private final Address5 address;

    public Employee5(long id, String name, Address5 address) {
        this.id = id;
        this.name = name;
        if (address != null) {
            Address5 address10 = new Address5(address.getCity(), address.getCountry());
            this.address = address10;
        } else {
            this.address = null;
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address4 getAddress() {
        if (address != null) {
            return new Address4(address.getCity(), address.getCountry());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address5 {
    private String city;

    private String country;

    public Address5(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
