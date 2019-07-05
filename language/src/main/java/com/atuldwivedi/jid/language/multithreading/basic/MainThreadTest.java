package com.atuldwivedi.jid.language.multithreading.basic;

public class MainThreadTest {
    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("Current thread name is : " + currentThreadName);
        System.out.println(currentThreadName + " thread id is: " + Thread.currentThread().getId());
        System.out.println(currentThreadName + " thread state is: " + Thread.currentThread().getState());
        System.out.println(currentThreadName + " thread priority is: " + Thread.currentThread().getPriority());
        System.out.println(currentThreadName + " thread class loader is: " + Thread.currentThread().getContextClassLoader());
        System.out.println(currentThreadName + " thread group is: " + Thread.currentThread().getThreadGroup());
        Thread.sleep(2000);
    }
}
