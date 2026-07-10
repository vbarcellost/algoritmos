package br.com.ebac.algoritmos;

import br.com.ebac.algoritmos.dp.FactorialBottomUp;
import br.com.ebac.algoritmos.dp.FactorialTopDown;
import br.com.ebac.algoritmos.fibonacci.Fibonacci;
import br.com.ebac.algoritmos.recursion.FactorialRecursive;

import java.math.BigInteger;
import java.util.Objects;

public class AlgorithmsSelfTest {

    public static void main(String[] args) {
        shouldCalculateFactorialWithRecursion();
        shouldCalculateFactorialAboveOneHundred();
        shouldCalculateFactorialWithTopDown();
        shouldCalculateFactorialWithBottomUp();
        shouldCalculateFibonacciWithAllApproaches();
        shouldRejectNegativeNumbers();

        System.out.println("Todos os testes passaram.");
    }

    private static void shouldCalculateFactorialWithRecursion() {
        assertEquals(BigInteger.valueOf(6), FactorialRecursive.calculate(3));
        assertEquals(BigInteger.valueOf(5040), FactorialRecursive.calculate(7));
    }

    private static void shouldCalculateFactorialAboveOneHundred() {
        assertEquals(new BigInteger("933262154439441526816992388562667004907159682643816214685929638952175999"
                + "93229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
                FactorialRecursive.calculate(100));
    }

    private static void shouldCalculateFactorialWithTopDown() {
        assertEquals(BigInteger.valueOf(6), FactorialTopDown.calculate(3));
        assertEquals(BigInteger.valueOf(5040), FactorialTopDown.calculate(7));
    }

    private static void shouldCalculateFactorialWithBottomUp() {
        assertEquals(BigInteger.valueOf(6), FactorialBottomUp.calculate(3));
        assertEquals(BigInteger.valueOf(5040), FactorialBottomUp.calculate(7));
    }

    private static void shouldCalculateFibonacciWithAllApproaches() {
        assertEquals(BigInteger.valueOf(55), Fibonacci.recursive(10));
        assertEquals(BigInteger.valueOf(55), Fibonacci.topDown(10));
        assertEquals(BigInteger.valueOf(55), Fibonacci.bottomUp(10));
    }

    private static void shouldRejectNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> FactorialRecursive.calculate(-1));
        assertThrows(IllegalArgumentException.class, () -> FactorialTopDown.calculate(-1));
        assertThrows(IllegalArgumentException.class, () -> FactorialBottomUp.calculate(-1));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.recursive(-1));
    }

    private static void assertEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError("Esperado: " + expected + ", obtido: " + actual);
        }
    }

    private static void assertThrows(Class<? extends Throwable> expectedType, Runnable action) {
        try {
            action.run();
        } catch (Throwable throwable) {
            if (expectedType.isInstance(throwable)) {
                return;
            }

            throw new AssertionError("Excecao inesperada: " + throwable);
        }

        throw new AssertionError("Era esperado lancar " + expectedType.getSimpleName());
    }
}
