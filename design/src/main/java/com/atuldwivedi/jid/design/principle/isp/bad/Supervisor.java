package com.atuldwivedi.jid.design.principle.isp.bad;

public class Supervisor {

    private Workable worker;

    public void setWorker(Workable worker) {
        this.worker = worker;
    }

    public void instruct() {
        worker.work();
    }
}
