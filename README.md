# Algoritmos avancados e resolucao de problemas de programacao - Parte 1

Exercicio da EBAC Java Pro, modulo 2.

## Exercicios resolvidos

### Exercicio 1 - Recursao

Criar um codigo que calcule o fatorial de um numero usando recursao.

```text
Entrada: 3
Saida: 6

Entrada: 7
Saida: 5040
```

A classe `FactorialRecursive` usa uma condicao de parada para `0!` e `1!`, e retorna `BigInteger` para suportar numeros acima do limite de `int` e `long`.

Sobre calcular fatorial acima de 100 com recursao: sim, e possivel calcular `100!` e valores um pouco maiores usando `BigInteger`, porque o resultado tem muitos digitos e estoura os tipos primitivos. Porem, para entradas muito grandes, uma solucao recursiva simples pode causar `StackOverflowError` pela profundidade da pilha de chamadas.

### Exercicio 2 - Programacao dinamica

Resolver o fatorial com programacao dinamica em duas abordagens:

- `FactorialTopDown`: usa recursao com memoizacao.
- `FactorialBottomUp`: usa uma tabela iterativa do menor caso ate o valor desejado.

Para o fatorial, a versao recursiva simples, top-down e bottom-up possuem complexidade de tempo `O(n)`. A diferenca principal esta no armazenamento e na estrategia: top-down calcula sob demanda e guarda resultados; bottom-up preenche a tabela em ordem.

### Exercicio 3 - Fibonacci

Comparar a complexidade de tempo das solucoes da serie de Fibonacci:

- Recursiva simples: `O(2^n)`, pois recalcula os mesmos subproblemas muitas vezes.
- Programacao dinamica: `O(n)`, pois cada valor de Fibonacci e calculado uma unica vez.

A programacao dinamica e melhor para Fibonacci porque elimina recalculos, reduzindo drasticamente o tempo de execucao.

## Estrutura

- `FactorialRecursive`: fatorial recursivo.
- `FactorialTopDown`: fatorial com programacao dinamica top-down.
- `FactorialBottomUp`: fatorial com programacao dinamica bottom-up.
- `Fibonacci`: implementacoes recursiva, top-down e bottom-up para comparacao.
- `FibonacciComplexity`: textos curtos com a comparacao pedida no exercicio.
- `App`: demonstra as respostas no console.
- `AlgorithmsSelfTest`: teste sem dependencias externas.
- Testes JUnit: cobertura equivalente para execucao com Maven.

## Como executar

Com Maven instalado:

```bash
mvn test
mvn exec:java -Dexec.mainClass="br.com.ebac.algoritmos.App"
```

Sem Maven, usando o JDK:

```bash
javac -d out src/main/java/br/com/ebac/algoritmos/recursion/FactorialRecursive.java src/main/java/br/com/ebac/algoritmos/dp/FactorialTopDown.java src/main/java/br/com/ebac/algoritmos/dp/FactorialBottomUp.java src/main/java/br/com/ebac/algoritmos/fibonacci/Fibonacci.java src/main/java/br/com/ebac/algoritmos/fibonacci/FibonacciComplexity.java src/main/java/br/com/ebac/algoritmos/App.java src/test/java/br/com/ebac/algoritmos/AlgorithmsSelfTest.java
java -cp out br.com.ebac.algoritmos.AlgorithmsSelfTest
java -cp out br.com.ebac.algoritmos.App
```
