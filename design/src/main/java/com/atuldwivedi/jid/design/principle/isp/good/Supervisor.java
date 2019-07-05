package com.atuldwivedi.jid.design.principle.isp.good;

import com.atuldwivedi.jid.design.principle.isp.bad.Workable;

public class Supervisor {

    private com.atuldwivedi.jid.design.principle.isp.bad.Workable workable;

    public void setWorkable(Workable workable) {
        this.workable = workable;
    }

    public void instruct() {
        workable.work();
    }
}
