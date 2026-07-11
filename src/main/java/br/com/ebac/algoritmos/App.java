package br.com.ebac.algoritmos;

import br.com.ebac.algoritmos.backtracking.SubsetBacktracking;
import br.com.ebac.algoritmos.dp.FactorialBottomUp;
import br.com.ebac.algoritmos.dp.FactorialTopDown;
import br.com.ebac.algoritmos.fibonacci.Fibonacci;
import br.com.ebac.algoritmos.fibonacci.FibonacciComplexity;
import br.com.ebac.algoritmos.greedy.GreedyCoinChange;
import br.com.ebac.algoritmos.recursion.FactorialRecursive;

import java.math.BigInteger;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("Algoritmos avancados - Parte 1");
        System.out.println();

        System.out.println("Exercicio 1 - Fatorial com recursao");
        printFactorialExamples();
        System.out.println("100! com BigInteger: " + FactorialRecursive.calculate(100));
        System.out.println(FactorialRecursive.explainLargeInput());

        System.out.println();
        System.out.println("Exercicio 2 - Fatorial com programacao dinamica");
        System.out.println("Top-down 7!: " + FactorialTopDown.calculate(7));
        System.out.println("Bottom-up 7!: " + FactorialBottomUp.calculate(7));
        System.out.println("Diferenca: " + FactorialTopDown.compareWithBottomUp());

        System.out.println();
        System.out.println("Exercicio 3 - Fibonacci");
        System.out.println("Fibonacci recursivo de 10: " + Fibonacci.recursive(10));
        System.out.println("Fibonacci top-down de 10: " + Fibonacci.topDown(10));
        System.out.println("Fibonacci bottom-up de 10: " + Fibonacci.bottomUp(10));
        System.out.println("Complexidade recursiva: " + FibonacciComplexity.recursiveComplexity());
        System.out.println("Complexidade dinamica: " + FibonacciComplexity.dynamicProgrammingComplexity());
        System.out.println("Por que DP e melhor: " + FibonacciComplexity.whyDynamicProgrammingIsBetter());

        System.out.println();
        System.out.println("Modulo 3 - Exercicio 1 - Backtracking");
        System.out.println("S = [1, 2, 3], n = 2");
        System.out.println("Saida: " + SubsetBacktracking.generate(List.of(1, 2, 3), 2));
        System.out.println("S = [1, 2, 3, 4], n = 1");
        System.out.println("Saida: " + SubsetBacktracking.generate(List.of(1, 2, 3, 4), 1));

        System.out.println();
        System.out.println("Modulo 3 - Exercicio 2 - Algoritmo guloso");
        var change = GreedyCoinChange.makeChange(18, List.of(5, 2, 1));
        System.out.printf("Quantia: %d | Moedas: %s | Saida: %d (%s)%n",
                change.amount(),
                List.of(5, 2, 1),
                change.coinCount(),
                change.groupedCoins());
    }

    private static void printFactorialExamples() {
        printFactorial(3, BigInteger.valueOf(6));
        printFactorial(7, BigInteger.valueOf(5040));
    }

    private static void printFactorial(int input, BigInteger expected) {
        var result = FactorialRecursive.calculate(input);
        System.out.printf("Entrada: %d | Saida: %s | Esperado: %s%n", input, result, expected);
    }
}
