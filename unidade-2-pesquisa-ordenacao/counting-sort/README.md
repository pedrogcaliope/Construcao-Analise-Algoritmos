# Counting Sort

Ordenação não comparativa por contagem de ocorrências. Inclui versão com offset para negativos.

## Como executar

```bash
javac -encoding UTF-8 CountingSort.java
java CountingSort
```

## Complexidade

| Tempo | Espaço auxiliar | Estável |
|---|---|---|
| O(n + k) | O(n + k) | Sim |

## Pré-condições

Chaves inteiras em um intervalo conhecido e limitado.

## Limitações

Ineficiente quando k é muito maior que n.

## Referência na apostila

Seção *Ordenação Linear* (Parte II).
