package br.com.ebac.algoritmos;

import br.com.ebac.algoritmos.backtracking.SubsetBacktracking;

import java.util.List;

public class App {

    public static void main(String[] args) {
        var elements = List.of(1, 2, 3);
        var subsetSize = 2;

        System.out.println("Algoritmos avancados - Parte 1");
        System.out.printf("S = %s, N = %d%n", elements, subsetSize);
        System.out.println("Subconjuntos: " + SubsetBacktracking.generate(elements, subsetSize));
    }
}
