package com.atuldwivedi.jid.language.immutability;

public class ImmutabilityTest3Probem1Solution {
    public static void main(String[] args) {
        Address3 address = new Address3("Bangalore", "India");
        Employee3 immutableEmployee = new Employee3(1001l, "Atul", address);
        System.out.println("Before: " + immutableEmployee);
        address.setCity("Mysore");
        System.out.println("After: " + immutableEmployee);
    }
}

final class Employee3 {
    private final long id;

    private final String name;

    private final Address3 address;

    public Employee3(long id, String name, Address3 address) {
        this.id = id;
        this.name = name;
        if (address != null) {
            Address3 address10 = new Address3(address.getCity(), address.getCountry());
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

    public Address3 getAddress() {
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

class Address3 {
    private String city;

    private String country;

    public Address3(String city, String country) {
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
