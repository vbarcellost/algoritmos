# Algoritmos avancados e resolucao de problemas de programacao - Parte 1

Exercicio da EBAC Java Pro sobre backtracking.

## Objetivo

Dado um conjunto `S` de elementos unicos, o algoritmo deve gerar todos os subconjuntos de tamanho `N`.

Exemplo:

```text
S = [1, 2, 3], N = 2
Saida = [1, 2], [1, 3], [2, 3]
```

## Implementacao

- `SubsetBacktracking`: usa recursao e backtracking para montar as combinacoes.
- `App`: executa um exemplo simples no console.
- `SubsetBacktrackingTest`: cobre os cenarios principais do exercicio com JUnit.
- `SubsetBacktrackingSelfTest`: permite conferir o projeto apenas com o JDK.

## Como executar

Com Maven instalado:

```bash
mvn test
mvn exec:java -Dexec.mainClass="br.com.ebac.algoritmos.App"
```

Sem Maven, usando o JDK:

```bash
javac -d out src/main/java/br/com/ebac/algoritmos/backtracking/SubsetBacktracking.java src/main/java/br/com/ebac/algoritmos/App.java src/test/java/br/com/ebac/algoritmos/backtracking/SubsetBacktrackingSelfTest.java
java -cp out br.com.ebac.algoritmos.backtracking.SubsetBacktrackingSelfTest
java -cp out br.com.ebac.algoritmos.App
```
