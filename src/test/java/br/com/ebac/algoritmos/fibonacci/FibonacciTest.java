package br.com.ebac.algoritmos.fibonacci;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FibonacciTest {

    @Test
    void shouldCalculateFibonacciWithAllApproaches() {
        assertEquals(BigInteger.valueOf(55), Fibonacci.recursive(10));
        assertEquals(BigInteger.valueOf(55), Fibonacci.topDown(10));
        assertEquals(BigInteger.valueOf(55), Fibonacci.bottomUp(10));
    }

    @Test
    void shouldRejectNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.recursive(-1));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.topDown(-1));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.bottomUp(-1));
    }

    @Test
    void shouldExplainComplexityComparison() {
        assertTrue(FibonacciComplexity.recursiveComplexity().contains("O(2^n)"));
        assertTrue(FibonacciComplexity.dynamicProgrammingComplexity().contains("O(n)"));
    }
}
