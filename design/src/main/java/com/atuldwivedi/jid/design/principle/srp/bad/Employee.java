package com.atuldwivedi.jid.design.principle.srp.bad;

import java.math.BigDecimal;

public class Employee {

    //matters a lot to CFO
    public BigDecimal calculatePay() {
        // calculate pay of employee
        // based on that employee’s contract, status, hours worked
        return BigDecimal.TEN;
    }

    //matters a lot to CTO
    public void save() {
        System.out.println("Persist the record into database");
    }

    //matters a lot to CFO
    public String reportHours() {
        return "Employee worked for 8 hours and paid 100$";
    }
}
