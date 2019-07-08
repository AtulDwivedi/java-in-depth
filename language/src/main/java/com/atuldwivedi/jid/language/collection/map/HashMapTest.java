package com.atuldwivedi.jid.language.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<Employee, String> employees = new HashMap<>();
        employees.put(new Employee(101, "User 1"), "User 1");
        employees.put(new Employee(102, "User 2"), "User 2");
        employees.put(new Employee(103, "User 3"), "User 3");
        employees.put(new Employee(104, "User 4"), "User 4");

        Iterator<Employee> iterator = employees.keySet().iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employees.get(employee));
            employees.remove(employee);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            employees.put(new Employee(105, "User"), "User");
        });

        executorService.submit(() -> {
            System.out.println(employees.get(new Employee(104, "User 4")));
        });

        executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }
}

class Employee {
    Integer id;

    String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}