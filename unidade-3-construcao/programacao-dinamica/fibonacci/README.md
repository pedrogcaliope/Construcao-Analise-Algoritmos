# Fibonacci — Recursivo, Memoização e Bottom-up

Três formas de calcular F(n): recursão ingênua, memoização top-down e tabulação bottom-up.

## Como executar

```bash
javac -encoding UTF-8 Fibonacci.java
java Fibonacci
```

## Complexidade

| Tempo | Espaço auxiliar | Estável |
|---|---|---|
| O(2ⁿ) / O(n) / O(n) | O(n) / O(n) / O(1) | N/A |

## Pré-condições

n ≥ 0.

## Limitações

`long` comporta F(n) até n ≈ 92; para n maiores seria necessário `BigInteger`.

## Referência na apostila

Seção *Programação Dinâmica* (Parte III).
