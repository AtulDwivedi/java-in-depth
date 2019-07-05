package com.atuldwivedi.jid.language.multithreading.basic;

import java.util.concurrent.TimeUnit;

public class CreateThreadUsingRunnable {
    public static void main(String[] args) throws InterruptedException {

        Thread printerThread = new Thread(new RunnablePrinter(), "HP Printer");

        System.out.println(printerThread.getName() + " state is: " + printerThread.getState());
        printerThread.start();
        System.out.println(printerThread.getName() + " state is: " + printerThread.getState());

        TimeUnit.SECONDS.sleep(2);

        System.out.println(printerThread.getName() + " state is: " + printerThread.getState());
    }
}

class RunnablePrinter implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread state is : " + Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getName() + " is Printing...");
    }
}
