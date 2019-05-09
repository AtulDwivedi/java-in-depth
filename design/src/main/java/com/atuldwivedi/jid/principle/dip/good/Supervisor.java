package com.atuldwivedi.jid.principle.dip.good;

public class Supervisor {

    Workable workable;

    public void setWorkable(Workable workable) {
        this.workable = workable;
    }

    public void instruct() {
        workable.work();
    }
}
