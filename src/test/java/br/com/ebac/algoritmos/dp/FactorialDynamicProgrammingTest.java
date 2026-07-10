package br.com.ebac.algoritmos.dp;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialDynamicProgrammingTest {

    @Test
    void shouldCalculateFactorialWithTopDown() {
        assertEquals(BigInteger.valueOf(6), FactorialTopDown.calculate(3));
        assertEquals(BigInteger.valueOf(5040), FactorialTopDown.calculate(7));
    }

    @Test
    void shouldCalculateFactorialWithBottomUp() {
        assertEquals(BigInteger.valueOf(6), FactorialBottomUp.calculate(3));
        assertEquals(BigInteger.valueOf(5040), FactorialBottomUp.calculate(7));
    }

    @Test
    void shouldRejectNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> FactorialTopDown.calculate(-1));
        assertThrows(IllegalArgumentException.class, () -> FactorialBottomUp.calculate(-1));
    }
}
