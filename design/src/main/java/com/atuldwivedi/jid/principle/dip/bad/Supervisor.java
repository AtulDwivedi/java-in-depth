package com.atuldwivedi.jid.principle.dip.bad;

public class Supervisor {

    Worker worker;

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void instruct() {
        worker.work();
    }
}
