package com.atuldwivedi.jid.principle.isp.bad;

public class FastWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Working fast.");
    }

    @Override
    public void eat() {
        System.out.println("Eating healthy.");
    }
}
