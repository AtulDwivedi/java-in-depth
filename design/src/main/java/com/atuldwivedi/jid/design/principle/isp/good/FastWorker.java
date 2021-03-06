package com.atuldwivedi.jid.design.principle.isp.good;

public class FastWorker implements Workable, Feedable {
    @Override
    public void work() {
        System.out.println("Working fast.");
    }

    @Override
    public void eat() {
        System.out.println("Eating healthy.");
    }
}
