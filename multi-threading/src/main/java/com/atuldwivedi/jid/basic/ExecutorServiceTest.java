package com.atuldwivedi.jid.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        int number = 10;

        NumberChecker numberChecker = new NumberChecker();
        List<Callable<Boolean>> numberCheckerTaks = new ArrayList<>();
        numberCheckerTaks.add(numberChecker.isEvenNumber(number));
        numberCheckerTaks.add(numberChecker.isOddNumber(number));

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            executorService.invokeAll(numberCheckerTaks).forEach(it -> {
                try {
                    Boolean value = it.get();
                    System.out.println(value);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnable runnableTask = () -> {
            try {
                System.out.println("Performing runnable task");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            System.out.println("Performing callable task");
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        executorService.execute(runnableTask);

        Future<?> runnableFuture = executorService.submit(runnableTask);
        Future<String> callableFuture = executorService.submit(callableTask);


        try {
            String callableInvokeAnyFuture = executorService.invokeAny(callableTasks);
            List<Future<String>> callableInvokeAllFutures = executorService.invokeAll(callableTasks);
            System.out.println(runnableFuture.get());
            System.out.println(callableFuture.get());
            System.out.println("Any: " + callableInvokeAnyFuture);
            List<String> list = new ArrayList<>();
            for (Future<String> callableInvokeAllFuture : callableInvokeAllFutures) {
                String s = callableInvokeAllFuture.get();
                list.add(s);
            }
            list.forEach(System.out::println);
            System.out.println(callableInvokeAllFutures);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }


}
