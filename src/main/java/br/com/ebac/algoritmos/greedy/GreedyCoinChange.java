package br.com.ebac.algoritmos.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class GreedyCoinChange {

    private GreedyCoinChange() {
    }

    public static ChangeResult makeChange(int amount, List<Integer> coins) {
        validate(amount, coins);

        var sortedCoins = coins.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        var remaining = amount;
        var usedCoins = new ArrayList<Integer>();

        for (var coin : sortedCoins) {
            while (remaining >= coin) {
                remaining -= coin;
                usedCoins.add(coin);
            }
        }

        return new ChangeResult(amount, remaining, usedCoins);
    }

    private static void validate(int amount, List<Integer> coins) {
        if (amount < 0) {
            throw new IllegalArgumentException("A quantia nao pode ser negativa");
        }

        Objects.requireNonNull(coins, "A lista de moedas nao pode ser nula");

        if (coins.isEmpty()) {
            throw new IllegalArgumentException("Informe pelo menos uma moeda");
        }

        if (coins.stream().anyMatch(coin -> coin == null || coin <= 0)) {
            throw new IllegalArgumentException("As moedas devem ser inteiros positivos");
        }
    }

    public record ChangeResult(int amount, int remaining, List<Integer> coins) {

        public ChangeResult {
            coins = List.copyOf(coins);
        }

        public int coinCount() {
            return coins.size();
        }

        public boolean isExact() {
            return remaining == 0;
        }

        public Map<Integer, Integer> groupedCoins() {
            var grouped = new LinkedHashMap<Integer, Integer>();
            for (var coin : coins) {
                grouped.merge(coin, 1, Integer::sum);
            }
            return grouped;
        }
    }
}
