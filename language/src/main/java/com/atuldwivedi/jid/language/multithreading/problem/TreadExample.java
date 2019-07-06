package com.atuldwivedi.jid.language.multithreading.problem;

import java.util.Scanner;

public class TreadExample {
    public static void main(String[] args)
            throws InterruptedException {
        final PC pc = new PC();

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static class PC {
        public void produce() throws InterruptedException {
            synchronized (this) {
                System.out.println("Producer: running");
                System.out.println("Producer: waiting");

                wait();

                System.out.println("Producer: resumed");
            }
        }

        public void consume() throws InterruptedException {
            Thread.sleep(1000);
            Scanner s = new Scanner(System.in);

            synchronized (this) {
                System.out.println("Consumer: Waiting for return key.");
                s.nextLine();
                System.out.println("Consumer: Return key pressed");

                notify();

                Thread.sleep(2000);
            }
        }
    }
}


