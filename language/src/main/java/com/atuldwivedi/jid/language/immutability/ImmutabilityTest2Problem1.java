package com.atuldwivedi.jid.language.immutability;

public class ImmutabilityTest2Problem1 {
    public static void main(String[] args) {
        Address2 address = new Address2("Bangalore", "India");
        Employee2 immutableEmployee = new Employee2(1001l, "Atul", address);
        System.out.println("Before: " + immutableEmployee);
        address.setCity("Mysore");
        System.out.println("After: " + immutableEmployee);
    }
}

final class Employee2 {
    private final long id;

    private final String name;

    private final Address2 address;

    public Employee2(long id, String name, Address2 address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address2 getAddress() {
        return address;
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

class Address2 {
    private String city;

    private String country;

    public Address2(String city, String country) {
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

