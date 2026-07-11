package br.com.ebac.algoritmos.greedy;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreedyCoinChangeTest {

    @Test
    void shouldMakeChangeUsingTheSmallestNumberOfAvailableCoins() {
        var result = GreedyCoinChange.makeChange(18, List.of(5, 2, 1));

        assertTrue(result.isExact());
        assertEquals(5, result.coinCount());
        assertEquals(List.of(5, 5, 5, 2, 1), result.coins());
        assertEquals(Map.of(5, 3, 2, 1, 1, 1), result.groupedCoins());
    }

    @Test
    void shouldSortCoinsBeforeApplyingGreedyStrategy() {
        var result = GreedyCoinChange.makeChange(18, List.of(1, 5, 2));

        assertEquals(List.of(5, 5, 5, 2, 1), result.coins());
    }

    @Test
    void shouldKeepRemainingAmountWhenExactChangeIsImpossible() {
        var result = GreedyCoinChange.makeChange(3, List.of(2));

        assertFalse(result.isExact());
        assertEquals(1, result.remaining());
        assertEquals(List.of(2), result.coins());
    }

    @Test
    void shouldRejectInvalidCoins() {
        assertThrows(IllegalArgumentException.class, () -> GreedyCoinChange.makeChange(10, List.of(5, 0, 1)));
    }
}
