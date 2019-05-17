package com.atuldwivedi.jid.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {

    static CompletableFuture<String> asyncSaySomeThing() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("here");
            completableFuture.complete("Hi");
        });
        return completableFuture;
    }

    static CompletableFuture<String> asyncSayAnotherThing() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("there");
            completableFuture.complete("Good Morning");
        });
        return completableFuture;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        CompletableFuture<String> one = asyncSaySomeThing();
        CompletableFuture<String> two = asyncSayAnotherThing();
        CompletableFuture.allOf(one, two);
    }
}
