package com.atuldwivedi.jid.design.principle.isp.good;

public class SlowWorker implements Workable, Feedable {
    @Override
    public void work() {
        System.out.println("Working slowly.");
    }

    @Override
    public void eat() {
        System.out.println("Eating non healthy.");
    }
}
