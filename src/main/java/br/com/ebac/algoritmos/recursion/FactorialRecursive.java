package br.com.ebac.algoritmos.recursion;

import java.math.BigInteger;

public final class FactorialRecursive {

    private FactorialRecursive() {
    }

    public static BigInteger calculate(int number) {
        validate(number);

        if (number <= 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(number).multiply(calculate(number - 1));
    }

    public static String explainLargeInput() {
        return "E possivel calcular fatorial acima de 100 com BigInteger, pois int e long estouram. "
                + "Para numeros muito grandes, a recursao simples pode falhar por limite da pilha.";
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Nao existe fatorial de numero negativo");
        }
    }
}
