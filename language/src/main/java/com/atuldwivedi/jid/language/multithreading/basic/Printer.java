package com.atuldwivedi.jid.language.multithreading.basic;

public class Printer implements Runnable {
    @Override
    public void run() {
        System.out.println("Printer is printing....");
    }
}
