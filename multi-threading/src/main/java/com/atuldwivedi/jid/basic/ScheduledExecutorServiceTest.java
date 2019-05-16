package com.atuldwivedi.jid.basic;

import java.sql.Time;
import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        Callable<String> callable = () -> {
            System.out.println("Callable");
            return "SUCCESS";
        };

        Runnable runnable = () -> {
            System.out.println("Callable");
        };

        scheduledExecutorService.schedule(callable, 1, TimeUnit.MILLISECONDS);

        Future<?> resultFuture = scheduledExecutorService
                .scheduleAtFixedRate(runnable, 100, 10, TimeUnit.MILLISECONDS);
    }

}
