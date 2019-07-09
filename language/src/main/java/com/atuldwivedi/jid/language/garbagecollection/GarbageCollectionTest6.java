package com.atuldwivedi.jid.language.garbagecollection;

/**
 * Java program to demonstrate:
 * How many objects are eligible for garbage collection after particular line execution
 */
public class GarbageCollectionTest6 {
    public static void main(String[] args) {
        GarbageCollectionTest6 t1 = new GarbageCollectionTest6();
        GarbageCollectionTest6 t2 = m1(t1);
        GarbageCollectionTest6 t3 = new GarbageCollectionTest6();

        //hom many objects are eligible for gc? - 1

    }

    static GarbageCollectionTest6 m1(GarbageCollectionTest6 temp) {
        temp = new GarbageCollectionTest6();
        return temp;
    }
} 
