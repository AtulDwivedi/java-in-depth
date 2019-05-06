package com.atuldwivedi.jid.basic;

public class MainThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Printer());
        System.out.println("Printer thread state: " + thread.getState());
        thread.start();
        System.out.println("Printer thread state: " + thread.getState());
        Thread.sleep(2000);
        System.out.println("Main thread state: " + Thread.currentThread().getState());
        System.out.println("Printer thread state: " + thread.getState());
    }
}
