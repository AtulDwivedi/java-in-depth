package com.atuldwivedi.jid.feature.java8.lambda;

import static java.util.Arrays.asList;

public class LambdaTest {
    public static void main(String[] args) {
        int i = 10;

        System.out.println(asList("A", "B").stream().filter(it -> it.equals("A")).findFirst().isPresent());

    }

}

interface Operator<T, R> {
    boolean isApplicable(T t);
}
