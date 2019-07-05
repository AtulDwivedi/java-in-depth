package com.atuldwivedi.jid.language.multithreading.basic;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        Callable<String> callable = () -> {
            System.out.println("Callable");
            return "SUCCESS";
        };

        Runnable runnable = () -> {
            System.out.println("Runnable");
        };

        scheduledExecutorService.schedule(callable, 10000, TimeUnit.MILLISECONDS);

//        Future<?> resultFuture = scheduledExecutorService
//                .scheduleAtFixedRate(runnable, 100, 10, TimeUnit.MILLISECONDS);
        //System.out.println(resultFuture.get());
    }


}
