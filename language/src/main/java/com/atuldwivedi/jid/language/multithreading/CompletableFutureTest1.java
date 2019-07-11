package com.atuldwivedi.jid.language.multithreading;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see <a href="https://www.baeldung.com/java-completablefuture">Reference 1</a>
 */
public class CompletableFutureTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(completableFutureAsSimpleFuture().get());

        CompletableFuture<String> future1 = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World!");
        System.out.println(future1.get());

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(s -> System.out.println(s + " Java World!"));

        CompletableFuture.supplyAsync(() -> "Hello").thenRun(() -> System.out.println("This is amazing."));

        runMultipleFuturesInParallel();
        runMultipleFuturesInParallelAndProcessCombinedResultOfFutures();
    }

    private static Future<String> completableFutureAsSimpleFuture() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            completableFuture.complete("CompletableFuture as simple Future");
            return null;
        });
        return completableFuture;
    }

    private static void runMultipleFuturesInParallel() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Java");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        System.out.println("Future 1 is " + future1.isDone() + ". It returns " + future1.get());
        System.out.println("Future 2 is " + future2.isDone() + ". It returns " + future2.get());
        System.out.println("Future 3 is " + future3.isDone() + ". It returns " + future3.get());


    }

    private static void runMultipleFuturesInParallelAndProcessCombinedResultOfFutures() {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Java");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        String message = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(message);
    }
}
