# Seleção de Atividades (Guloso)

Escolhe gulosamente a próxima atividade compatível com a última selecionada, maximizando a quantidade.

## Como executar

```bash
javac -encoding UTF-8 SelecaoAtividades.java
java SelecaoAtividades
```

## Complexidade

| Tempo | Espaço auxiliar | Estável |
|---|---|---|
| O(n log n) | O(n) | N/A |

## Pré-condições

Lista ordenada por tempo de término crescente.

## Limitações

Maximiza apenas a quantidade de atividades, não pondera por valor/prioridade.

## Referência na apostila

Seção *Algoritmos Gulosos* (Parte III).
