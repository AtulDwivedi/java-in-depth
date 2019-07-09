package com.atuldwivedi.jid.language.garbagecollection;

/**
 * Java program to demonstrate:
 * GC calls finalize method on any object only once
 */
public class GarbageCollectionTest4 {
    static GarbageCollectionTest4 t;

    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        GarbageCollectionTest4 t1 = new GarbageCollectionTest4();

        t1 = null;

        //finalize will be called but object would not be garbage collected
        System.gc();

        Thread.sleep(1000);

        t = null;

        //object would be garbage collected without calling finalize
        System.gc();

        Thread.sleep(1000);

        System.out.println("finalize method called " + count + " times");

    }

    @Override
    protected void finalize() {
        count++;

        t = this;

    }

} 
