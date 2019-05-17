package com.atuldwivedi.jid.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class NumberChecker {

    public Callable<Boolean> isEvenNumber(int number) {
        return () -> {
            System.out.println("Checking Even");
            TimeUnit.MILLISECONDS.sleep(5000);
            if (number % 2 == 0) {
                return true;
            }
            return false;
        };
    }

    public Callable<Boolean> isOddNumber(int number) {
        return () -> {
            System.out.println("Checking Odd");
            TimeUnit.MILLISECONDS.sleep(5000);
            if (number % 2 != 0) {
                return true;
            }
            return false;
        };
    }
}
