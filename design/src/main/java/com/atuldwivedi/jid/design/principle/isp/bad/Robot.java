package com.atuldwivedi.jid.design.principle.isp.bad;

public class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Working efficiently.");
    }

    // this is bad design
    @Override
    public void eat() {
        System.out.println("I do not eat.");
    }
}
