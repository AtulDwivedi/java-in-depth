package com.atuldwivedi.jid.pattern.singleton;

public class Singleton4 {

    private static Singleton4 singleton4 = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return singleton4;
    }
}
