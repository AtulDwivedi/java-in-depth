package com.atuldwivedi.jid.design.principle.dip.bad;

public class SuperWorker {
    //Supervisor need to be changed in order to add SuperWorker capability
    public void work() {
        System.out.println("Worker is working.");
    }
}
