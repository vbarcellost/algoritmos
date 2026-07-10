package br.com.ebac.algoritmos.recursion;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialRecursiveTest {

    @Test
    void shouldCalculateFactorialWithRecursion() {
        assertEquals(BigInteger.valueOf(6), FactorialRecursive.calculate(3));
        assertEquals(BigInteger.valueOf(5040), FactorialRecursive.calculate(7));
    }

    @Test
    void shouldCalculateFactorialAboveOneHundred() {
        assertEquals(new BigInteger("933262154439441526816992388562667004907159682643816214685929638952175999"
                + "93229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
                FactorialRecursive.calculate(100));
    }

    @Test
    void shouldRejectNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> FactorialRecursive.calculate(-1));
    }
}
