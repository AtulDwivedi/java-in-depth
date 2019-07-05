package com.atuldwivedi.jid.language.multithreading.basic;

import java.util.concurrent.TimeUnit;

public class CreateThreadUsingThread {
    public static void main(String[] args) throws InterruptedException {

        ThreadPrinter printerThread = new ThreadPrinter("Canon Printer");

        System.out.println(printerThread.getName() + " state is: " + printerThread.getState());
        printerThread.start();
        System.out.println(printerThread.getName() + " state is: " + printerThread.getState());

        TimeUnit.SECONDS.sleep(2);

        System.out.println(printerThread.getName() + " state is: " + printerThread.getState());
    }
}

class ThreadPrinter extends Thread {

    private final String threadName;

    public ThreadPrinter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread state is : " + Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getName() + " is Printing...");
    }
}
