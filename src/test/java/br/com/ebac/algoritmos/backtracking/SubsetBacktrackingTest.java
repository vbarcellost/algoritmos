package br.com.ebac.algoritmos.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SubsetBacktrackingTest {

    @Test
    void shouldGenerateAllSubsetsWithTwoElements() {
        var subsets = SubsetBacktracking.generate(List.of(1, 2, 3), 2);

        assertEquals(List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3)
        ), subsets);
    }

    @Test
    void shouldGenerateAllSubsetsWithOneElement() {
        var subsets = SubsetBacktracking.generate(List.of("A", "B", "C"), 1);

        assertEquals(List.of(
                List.of("A"),
                List.of("B"),
                List.of("C")
        ), subsets);
    }

    @Test
    void shouldGenerateEmptySubsetWhenSizeIsZero() {
        var subsets = SubsetBacktracking.generate(List.of(1, 2, 3), 0);

        assertEquals(List.of(List.of()), subsets);
    }

    @Test
    void shouldRejectDuplicatedElements() {
        assertThrows(IllegalArgumentException.class, () -> SubsetBacktracking.generate(List.of(1, 1, 2), 2));
    }

    @Test
    void shouldRejectSubsetSizeGreaterThanSet() {
        assertThrows(IllegalArgumentException.class, () -> SubsetBacktracking.generate(List.of(1, 2), 3));
    }
}
