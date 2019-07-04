package com.atuldwivedi.jid.problem;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class ProducerConsumeTest {
    public static void main(String[] args) throws InterruptedException {
        final ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

class ProducerConsumer {
    private LinkedList<Integer> work = new LinkedList<>();
    private final int capacity = 2;

    public void produce() throws InterruptedException {
        Integer value = 0;
        while (true) {
            synchronized (this) {
                while (work.size() == capacity) {
                    wait();
                }

                Integer val = value++;
                System.out.println("+ Producer produced: " + val);
                work.add(val);

                notify();
                TimeUnit.SECONDS.sleep(1);

            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (work.isEmpty()) {
                    wait();
                }

                Integer val = work.removeFirst();
                System.out.println("- Consumer consumed: " + val);
                notify();
                TimeUnit.SECONDS.sleep(1);

            }
        }
    }
}
