# Problema do Troco (Guloso)

Usa a moeda de maior valor possível a cada passo. Inclui contraexemplo em sistema não canônico.

## Como executar

```bash
javac -encoding UTF-8 Troco.java
java Troco
```

## Complexidade

| Tempo | Espaço auxiliar | Estável |
|---|---|---|
| O(k) | O(k) | N/A |

## Pré-condições

`moedas[]` ordenado de forma decrescente.

## Limitações

Só garante ótimo em sistemas canônicos (ex.: {25,10,5,1}).

## Referência na apostila

Seção *Algoritmos Gulosos* (Parte III).
