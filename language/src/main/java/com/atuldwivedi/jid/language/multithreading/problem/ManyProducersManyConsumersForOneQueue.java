package com.atuldwivedi.jid.language.multithreading.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ManyProducersManyConsumersForOneQueue {
    public static void main(String[] args) {
        final Queue<Integer> workQueue = new LinkedList<>();
        IntegerProducer producer = new IntegerProducer(10, workQueue, 0);
        IntegerConsumer consumenr = new IntegerConsumer(workQueue);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable producerWorker = () -> {
            try {
                producer.produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable consumerWorker = () -> {
            try {
                consumenr.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        executorService.submit(producerWorker);
        executorService.submit(producerWorker);
        executorService.submit(producerWorker);
        executorService.submit(consumerWorker);
        executorService.submit(consumerWorker);
        executorService.submit(consumerWorker);


    }
}

class IntegerProducer {
    private final Integer capacity;

    private final Queue<Integer> workQueue;

    private final AtomicInteger counter;

    public IntegerProducer(Integer capacity, Queue<Integer> workQueue, Integer initialValue) {
        this.capacity = capacity;
        this.workQueue = workQueue;
        counter = new AtomicInteger(initialValue);
    }

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (workQueue) {
                while (workQueue.size() == capacity) {
                    workQueue.wait();
                }
                Integer value = counter.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " produced: " + value);
                workQueue.add(value);
                workQueue.notifyAll();
                TimeUnit.SECONDS.sleep(1);
            }

        }
    }
}

class IntegerConsumer {
    private final Queue<Integer> workQueue;

    public IntegerConsumer(Queue<Integer> workQueue) {
        this.workQueue = workQueue;
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (workQueue) {
                while (workQueue.isEmpty()) {
                    workQueue.wait();
                }
                Integer value = workQueue.peek();
                System.out.println(Thread.currentThread().getName() + " consumed: " + value);
                workQueue.remove();

                workQueue.notifyAll();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
