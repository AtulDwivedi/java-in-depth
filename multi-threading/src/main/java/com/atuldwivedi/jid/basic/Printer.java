package com.atuldwivedi.jid.basic;

public class Printer implements Runnable {
    @Override
    public void run() {
        System.out.println("Printer is printing....");
    }
}
