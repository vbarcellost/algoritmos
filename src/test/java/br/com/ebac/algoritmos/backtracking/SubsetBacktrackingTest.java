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
        var subsets = SubsetBacktracking.generate(List.of(1, 2, 3, 4), 1);

        assertEquals(List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(4)
        ), subsets);
    }

    @Test
    void shouldDiscardInvalidPartialSolutions() {
        var subsets = SubsetBacktracking.generate(List.of(1, 2, 3, 4), 3);

        assertEquals(4, subsets.size());
        assertEquals(List.of(1, 2, 3), subsets.get(0));
        assertEquals(List.of(2, 3, 4), subsets.get(3));
    }

    @Test
    void shouldRejectDuplicatedElements() {
        assertThrows(IllegalArgumentException.class, () -> SubsetBacktracking.generate(List.of(1, 1, 2), 2));
    }
}
