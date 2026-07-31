# Radix Sort (LSD, base 10)

Ordena por dígito, do menos ao mais significativo, usando Counting Sort estável como sub-rotina.

## Como executar

```bash
javac -encoding UTF-8 RadixSort.java
java RadixSort
```

## Complexidade

| Tempo | Espaço auxiliar | Estável |
|---|---|---|
| O(d·(n + b)) | O(n + b) | Sim |

## Pré-condições

Chaves inteiras não negativas.

## Limitações

Custo depende do número de dígitos da maior chave.

## Referência na apostila

Seção *Ordenação Linear* (Parte II).
