package br.com.ebac.algoritmos.backtracking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public final class SubsetBacktracking {

    private SubsetBacktracking() {
    }

    public static <T> List<List<T>> generate(List<T> elements, int subsetSize) {
        validate(elements, subsetSize);

        var result = new ArrayList<List<T>>();
        backtrack(elements, subsetSize, 0, new ArrayList<>(), result);
        return result;
    }

    private static <T> void backtrack(
            List<T> elements,
            int subsetSize,
            int startIndex,
            List<T> current,
            List<List<T>> result
    ) {
        if (current.size() == subsetSize) {
            result.add(new ArrayList<>(current));
            return;
        }

        var remainingSlots = subsetSize - current.size();
        for (int index = startIndex; index <= elements.size() - remainingSlots; index++) {
            current.add(elements.get(index));
            backtrack(elements, subsetSize, index + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private static <T> void validate(List<T> elements, int subsetSize) {
        Objects.requireNonNull(elements, "A lista de elementos nao pode ser nula");

        if (subsetSize < 0) {
            throw new IllegalArgumentException("O tamanho do subconjunto nao pode ser negativo");
        }

        if (subsetSize > elements.size()) {
            throw new IllegalArgumentException("O tamanho do subconjunto nao pode ser maior que o conjunto");
        }

        if (new LinkedHashSet<>(elements).size() != elements.size()) {
            throw new IllegalArgumentException("O conjunto deve possuir apenas elementos unicos");
        }
    }
}
