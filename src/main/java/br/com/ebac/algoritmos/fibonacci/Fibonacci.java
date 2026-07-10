package br.com.ebac.algoritmos.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public final class Fibonacci {

    private Fibonacci() {
    }

    public static BigInteger recursive(int number) {
        validate(number);

        if (number <= 1) {
            return BigInteger.valueOf(number);
        }

        return recursive(number - 1).add(recursive(number - 2));
    }

    public static BigInteger topDown(int number) {
        validate(number);

        var memo = new HashMap<Integer, BigInteger>();
        memo.put(0, BigInteger.ZERO);
        memo.put(1, BigInteger.ONE);

        return topDown(number, memo);
    }

    public static BigInteger bottomUp(int number) {
        validate(number);

        if (number <= 1) {
            return BigInteger.valueOf(number);
        }

        var table = new BigInteger[number + 1];
        table[0] = BigInteger.ZERO;
        table[1] = BigInteger.ONE;

        for (int current = 2; current <= number; current++) {
            table[current] = table[current - 1].add(table[current - 2]);
        }

        return table[number];
    }

    private static BigInteger topDown(int number, Map<Integer, BigInteger> memo) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        var result = topDown(number - 1, memo).add(topDown(number - 2, memo));
        memo.put(number, result);
        return result;
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci nao aceita numero negativo");
        }
    }
}
