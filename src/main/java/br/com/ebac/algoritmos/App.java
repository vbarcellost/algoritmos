package br.com.ebac.algoritmos;

import br.com.ebac.algoritmos.dp.FactorialBottomUp;
import br.com.ebac.algoritmos.dp.FactorialTopDown;
import br.com.ebac.algoritmos.fibonacci.Fibonacci;
import br.com.ebac.algoritmos.fibonacci.FibonacciComplexity;
import br.com.ebac.algoritmos.recursion.FactorialRecursive;

import java.math.BigInteger;

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
