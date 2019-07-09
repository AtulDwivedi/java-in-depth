package com.atuldwivedi.jid.language.garbagecollection;

/**
 * Java program to demonstrate:
 * GC ignores all the exceptions raised in finalize method and
 * program will terminate normally
 */
public class GarbageCollectionTest3 {
    public static void main(String[] args) throws InterruptedException {
        GarbageCollectionTest3 t = new GarbageCollectionTest3();

        t = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println("end main");
    }

    @Override
    protected void finalize() {
        System.out.println("finalize method called");

        //arithmetic exception
        System.out.println(10 / 0);
    }

} 
