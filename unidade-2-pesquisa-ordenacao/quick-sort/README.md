# Quicksort

Particiona o vetor em torno de um pivô (Lomuto) e ordena recursivamente as duas partes. Inclui versão randomizada.

## Como executar

```bash
javac -encoding UTF-8 QuickSort.java
java QuickSort
```

## Complexidade

| Tempo | Espaço auxiliar | Estável |
|---|---|---|
| Pior: O(n²) · Esperado: O(n log n) | O(log n) | Não |

## Pré-condições

Nenhuma.

## Limitações

A versão determinística tem pior caso O(n²) em vetores já ordenados; prefira a randomizada.

## Referência na apostila

Seção *Quicksort* (Parte II).
