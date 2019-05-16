package com.atuldwivedi.jid.basic;

import java.util.concurrent.Callable;

public class NumberChecker {

    public Callable<Boolean> isEvenNumber(int number) {
        return () -> {
            if (number % 2 == 0) {
                return true;
            }
            return false;
        };
    }

    public Callable<Boolean> isOddNumber(int number) {
        return () -> {
            if (number % 2 != 0) {
                return true;
            }
            return false;
        };
    }
}
