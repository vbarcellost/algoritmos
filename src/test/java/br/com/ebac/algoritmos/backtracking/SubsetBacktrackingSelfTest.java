package br.com.ebac.algoritmos.backtracking;

import java.util.List;
import java.util.Objects;

public class SubsetBacktrackingSelfTest {

    public static void main(String[] args) {
        shouldGenerateAllSubsetsWithTwoElements();
        shouldGenerateAllSubsetsWithOneElement();
        shouldGenerateEmptySubsetWhenSizeIsZero();
        shouldRejectDuplicatedElements();
        shouldRejectSubsetSizeGreaterThanSet();

        System.out.println("Todos os testes passaram.");
    }

    private static void shouldGenerateAllSubsetsWithTwoElements() {
        var subsets = SubsetBacktracking.generate(List.of(1, 2, 3), 2);

        assertEquals(List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3)
        ), subsets);
    }

    private static void shouldGenerateAllSubsetsWithOneElement() {
        var subsets = SubsetBacktracking.generate(List.of("A", "B", "C"), 1);

        assertEquals(List.of(
                List.of("A"),
                List.of("B"),
                List.of("C")
        ), subsets);
    }

    private static void shouldGenerateEmptySubsetWhenSizeIsZero() {
        var subsets = SubsetBacktracking.generate(List.of(1, 2, 3), 0);

        assertEquals(List.of(List.of()), subsets);
    }

    private static void shouldRejectDuplicatedElements() {
        assertThrows(IllegalArgumentException.class, () -> SubsetBacktracking.generate(List.of(1, 1, 2), 2));
    }

    private static void shouldRejectSubsetSizeGreaterThanSet() {
        assertThrows(IllegalArgumentException.class, () -> SubsetBacktracking.generate(List.of(1, 2), 3));
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
