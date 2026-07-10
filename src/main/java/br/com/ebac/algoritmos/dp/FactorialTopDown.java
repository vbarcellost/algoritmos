package br.com.ebac.algoritmos.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public final class FactorialTopDown {

    private FactorialTopDown() {
    }

    public static BigInteger calculate(int number) {
        validate(number);

        var memo = new HashMap<Integer, BigInteger>();
        memo.put(0, BigInteger.ONE);
        memo.put(1, BigInteger.ONE);

        return calculate(number, memo);
    }

    private static BigInteger calculate(int number, Map<Integer, BigInteger> memo) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        var result = BigInteger.valueOf(number).multiply(calculate(number - 1, memo));
        memo.put(number, result);
        return result;
    }

    public static String compareWithBottomUp() {
        return "Top-down usa recursao com memoizacao e calcula sob demanda; bottom-up preenche a tabela iterativamente.";
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Nao existe fatorial de numero negativo");
        }
    }
}
