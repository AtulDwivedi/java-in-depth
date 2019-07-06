package com.atuldwivedi.jid.language.multithreading.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TypicalProducerConsumeTest {
    public static void main(String[] args) throws InterruptedException {
        final Queue<Integer> workQueue = new LinkedList<>();

        Thread producer = new Thread(() -> {
            try {
                new Producer(workQueue).produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread consumer = new Thread(() -> {
            try {
                new Consumer(workQueue).consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

class Producer {

    private final Queue<Integer> workQueue;

    private static final int CAPACITY = 3;

    private final AtomicInteger counter = new AtomicInteger(0);

    Producer(Queue<Integer> workQueue) {
        this.workQueue = workQueue;
    }

    void produce() throws InterruptedException {
        while (true) {
            synchronized (workQueue) {
                while (workQueue.size() == CAPACITY) {
                    workQueue.wait();
                }

                Integer value = counter.incrementAndGet();
                System.out.println("+ Producer: " + value);
                workQueue.add(value);

                workQueue.notify();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}

class Consumer {
    private final Queue<Integer> workQueue;

    Consumer(Queue<Integer> workQueue) {
        this.workQueue = workQueue;
    }

    void consume() throws InterruptedException {
        while (true) {
            synchronized (workQueue) {
                while (workQueue.isEmpty()) {
                    workQueue.wait();
                }
                Integer value = workQueue.peek();
                System.out.println("- Consumer: " + value);
                workQueue.remove();

                workQueue.notify();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}