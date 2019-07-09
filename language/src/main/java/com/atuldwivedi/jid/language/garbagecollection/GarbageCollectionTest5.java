package com.atuldwivedi.jid.language.garbagecollection;

/**
 * Java program to demonstrate:
 * How many objects are eligible for garbage collection after particular line execution
 */
public class GarbageCollectionTest5 {
    public static void main(String[] args) {
        //hom many objects are eligible for gc? - 2
        m1();
    }

    static void m1() {
        GarbageCollectionTest5 t1 = new GarbageCollectionTest5();
        GarbageCollectionTest5 t2 = new GarbageCollectionTest5();
    }
} 
