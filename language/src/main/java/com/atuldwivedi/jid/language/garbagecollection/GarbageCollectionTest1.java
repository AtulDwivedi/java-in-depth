package com.atuldwivedi.jid.language.garbagecollection;

/**
 * Java program to demonstrate:
 * that System.gc() and Runtime.getRuntime().gc() request JVM to run GC then how GC calls finalize
 * it also demonstrate that
 * There is no guarantee that methods System.gc() and Runtime.getRuntime().gc()
 * will definitely run Garbage Collector.
 */
public class GarbageCollectionTest1 {
    public static void main(String[] args) throws InterruptedException {
        GarbageCollectionTest1 t1 = new GarbageCollectionTest1();
        GarbageCollectionTest1 t2 = new GarbageCollectionTest1();

        t1 = null;

        // requesting JVM for running Garbage Collector
        System.gc();

        t2 = null;

        // requesting JVM for running Garbage Collector
        Runtime.getRuntime().gc();

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method called");
        System.out.println("Object garbage collected : " + this);
    }
} 
