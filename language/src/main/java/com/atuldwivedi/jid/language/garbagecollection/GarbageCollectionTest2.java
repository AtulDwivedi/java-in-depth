package com.atuldwivedi.jid.language.garbagecollection;

/**
 * Java program to demonstrate:
 * that GC is called on object before destroying it
 * so here str is eligible for garbage collection hence finalize of String class would be called (if overridden)
 * not finalize of GarbageCollectionTest2 class
 */
public class GarbageCollectionTest2 {
    public static void main(String[] args) throws InterruptedException {
        String str = new String("GarbageCollectionTest3");

        str = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println("end of main");
    }

    @Override
    protected void finalize() {
        System.out.println("finalize method called");
    }
} 
