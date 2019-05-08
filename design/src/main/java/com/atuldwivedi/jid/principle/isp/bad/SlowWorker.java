package com.atuldwivedi.jid.principle.isp.bad;

public class SlowWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Working slowly.");
    }

    @Override
    public void eat() {
        System.out.println("Eating non healthy.");
    }
}
