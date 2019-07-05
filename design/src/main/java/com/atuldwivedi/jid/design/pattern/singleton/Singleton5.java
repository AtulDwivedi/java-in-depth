package com.atuldwivedi.jid.design.pattern.singleton;

import java.io.Serializable;

public class Singleton5 implements Serializable {

    private static Singleton5 singleton5;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (singleton5 == null) {
            synchronized (Singleton5.class) {
                if (singleton5 == null) {
                    singleton5 = new Singleton5();
                }
            }
        }
        return singleton5;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
