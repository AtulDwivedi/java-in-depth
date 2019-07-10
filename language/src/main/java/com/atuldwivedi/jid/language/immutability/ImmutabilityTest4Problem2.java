package com.atuldwivedi.jid.language.immutability;

public class ImmutabilityTest4Problem2 {
    public static void main(String[] args) {
        Address5 address = new Address5("Bangalore", "India");
        Employee5 immutableEmployee = new Employee5(1001l, "Atul", address);
        System.out.println("Before: " + immutableEmployee);
        immutableEmployee.getAddress().setCity("New York");
        System.out.println("After: " + immutableEmployee);
    }
}

final class Employee4 {
    private final long id;

    private final String name;

    private final Address5 address;

    public Employee4(long id, String name, Address5 address) {
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

    public Address5 getAddress() {
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

class Address4 {
    private String city;

    private String country;

    public Address4(String city, String country) {
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
