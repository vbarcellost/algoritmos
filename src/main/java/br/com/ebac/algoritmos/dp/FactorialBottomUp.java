package br.com.ebac.algoritmos.dp;

import java.math.BigInteger;

public final class FactorialBottomUp {

    private FactorialBottomUp() {
    }

    public static BigInteger calculate(int number) {
        validate(number);

        var table = new BigInteger[number + 1];
        table[0] = BigInteger.ONE;

        for (int current = 1; current <= number; current++) {
            table[current] = BigInteger.valueOf(current).multiply(table[current - 1]);
        }

        return table[number];
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Nao existe fatorial de numero negativo");
        }
    }
}
