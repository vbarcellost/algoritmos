package br.com.ebac.algoritmos.fibonacci;

public final class FibonacciComplexity {

    private FibonacciComplexity() {
    }

    public static String recursiveComplexity() {
        return "A solucao recursiva simples tem tempo O(2^n), porque recalcula os mesmos valores diversas vezes.";
    }

    public static String dynamicProgrammingComplexity() {
        return "A solucao com programacao dinamica tem tempo O(n), porque cada subproblema e resolvido uma unica vez.";
    }

    public static String whyDynamicProgrammingIsBetter() {
        return "Programacao dinamica e melhor para Fibonacci porque reutiliza resultados ja calculados e evita recomputacao.";
    }
}
