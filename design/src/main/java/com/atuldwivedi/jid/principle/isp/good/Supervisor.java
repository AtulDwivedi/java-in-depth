package com.atuldwivedi.jid.principle.isp.good;

import com.atuldwivedi.jid.principle.isp.bad.Workable;

public class Supervisor {

    private Workable workable;

    public void setWorkable(Workable workable) {
        this.workable = workable;
    }

    public void instruct() {
        workable.work();
    }
}
