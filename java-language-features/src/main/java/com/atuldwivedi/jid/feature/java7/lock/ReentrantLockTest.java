package com.atuldwivedi.jid.feature.java7.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Printer("Task 1", reentrantLock));
        executorService.execute(new Printer("Task 2", reentrantLock));
        executorService.execute(new Printer("Task 3", reentrantLock));
        executorService.execute(new Printer("Task 4", reentrantLock));
        executorService.shutdown();
    }

}

class Printer implements Runnable {

    private String name;

    private ReentrantLock reentrantLock;

    Printer(String name, ReentrantLock reentrantLock) {
        this.name = name;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        boolean isJobCompleted = false;
        while (!isJobCompleted) {
            boolean isPrinterReadyToUse = reentrantLock.tryLock();
            if (isPrinterReadyToUse) {
                    System.out.println(name + " got access to printer.");
                try {
                    reentrantLock.lock();
                    try {
                        System.out.println(name + " lock hold count: " + reentrantLock.getHoldCount());
                        System.out.println(name + " is printing...");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(name + " is done with printing.");
                        reentrantLock.unlock();
                    }
                    System.out.println(name + " lock hold count: " + reentrantLock.getHoldCount());
                    isJobCompleted = true;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(name + " releasing the printer.");
                    reentrantLock.unlock();
                }
                System.out.println(name + " lock hold count: " + reentrantLock.getHoldCount());

            } else {
                System.out.println(name + " waiting to get access to printer.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}