# Construção e Análise de Algoritmos — Repositório de Implementações

Repositório oficial de implementações completas dos algoritmos estudados na
disciplina **Construção e Análise de Algoritmos**, Curso de Ciência da
Computação. Ele complementa a apostila da disciplina: enquanto a apostila
traz pseudocódigo, explicação passo a passo e análise de complexidade, aqui
você encontra a **implementação real em Java, testada e pronta para
executar**.

## Como usar este repositório

Cada algoritmo vive em sua própria pasta, autocontida, com:

- **um `.java`** (nome = nome do algoritmo, ex.: `MergeSort.java`) —
  implementação do algoritmo e um método `main` que demonstra o processo
  passo a passo com um exemplo de entrada, seguido de verificações de
  corretude silenciosas (`assert`);
- **`README.md`** — complexidade (tempo/espaço), pré-condições,
  limitações e referência à seção correspondente da apostila.

Não há dependências externas (sem Maven/Gradle, sem bibliotecas de
terceiros) — basta o JDK.

### Pré-requisitos

- **Java 21** ou superior ([Adoptium Temurin](https://adoptium.net/) ou
  qualquer distribuição OpenJDK).

### Executando um algoritmo

```bash
cd unidade-2-pesquisa-ordenacao/merge-sort
javac -encoding UTF-8 MergeSort.java
java MergeSort
```

Saída esperada (resumida):

```
▸ Merge Sort
────────────────────────────────────────
Entrada  [6, 3, 5, 1, 8, 2, 4, 7]

  [6, 3, 5, 1, 8, 2, 4, 7]
    [6, 3, 5, 1]
      [6, 3]
      -> [3, 6]
      ...
    -> [1, 3, 5, 6]
    ...
  -> [1, 2, 3, 4, 5, 6, 7, 8]

Ordenado [1, 2, 3, 4, 5, 6, 7, 8]
```

Cada `main` demonstra o algoritmo executando de verdade sobre um exemplo
(em geral, o mesmo usado na apostila), e não apenas imprime um resultado
final. Internamente, os cenários relevantes (vetor vazio, um elemento,
pior caso, elementos repetidos etc.) são checados com `assert`, que não
produz nenhuma saída quando tudo está correto. Para ativar essas
verificações explicitamente:

```bash
java -ea MergeSort
```

Com `-ea`, qualquer inconsistência interrompe a execução com
`AssertionError` — útil para validar o repositório antes de uma aula ou
em um script de CI. Sem `-ea` (uso normal), os `assert` são ignorados e o
programa apenas roda a demonstração.

### Executando tudo de uma vez

```bash
find . -name "*.java" | while read -r f; do
  dir=$(dirname "$f"); class=$(basename "$f" .java)
  echo "== $f =="
  (cd "$dir" && javac -encoding UTF-8 "$class.java" && java -ea "$class") || exit 1
done
```

## Estrutura do repositório

```
Construcao-Analise-Algoritmos/
├── README.md                                   (este arquivo)
├── LICENSE
├── .gitignore
├── .github/workflows/test.yml                  (CI: compila e roda tudo a cada push)
├── unidade-2-pesquisa-ordenacao/
│   ├── busca-linear-binaria/
│   ├── insertion-sort/
│   ├── selection-sort/
│   ├── bubble-sort/
│   ├── merge-sort/
│   ├── heap-sort/
│   ├── quick-sort/
│   ├── counting-sort/
│   └── radix-sort/
└── unidade-3-construcao/
    ├── programacao-dinamica/
    │   ├── fibonacci/
    │   └── matriz-cadeia/
    └── gulosos/
        ├── troco/
        └── selecao-atividades/
```

Cada pasta de algoritmo corresponde a exatamente uma caixa **"Implementação
completa"** na apostila, que aponta para o caminho
`unidade-x/.../algoritmo` dentro da tag/versão indicada (ver seção
*Versionamento* abaixo).

## Convenções de código

- Java puro, sem dependências externas;
- Nomes de variáveis e comentários em português, alinhados à nomenclatura
  usada na apostila (`p`, `r`, `q`, `A`, `n`, etc. quando fizer sentido);
- Cada `.java` é autocontido (pacote *default*, um algoritmo por classe,
  nome do arquivo = nome da classe), para que baste `javac` + `java` sem
  configurar *classpath*, e sem conflito de nomes entre pastas;
- Uso de `System.setOut(new PrintStream(System.out, true,
  StandardCharsets.UTF_8))` no início de cada `main` para garantir a
  exibição correta de acentuação, independentemente da *locale*/codificação
  do sistema operacional onde o código é executado;
- Corretude verificada com `assert` (nativo do Java, sem dependências): a
  saída no console fica dedicada à demonstração do algoritmo, e as
  verificações só se manifestam (com `AssertionError`) se algo estiver
  errado e o programa for executado com `-ea`.

## Convenção de índices: 0-based (Java) × 1-based (apostila)

A apostila apresenta os pseudocódigos com vetores **1-based** (índices de
`1` a `n`), como é tradição em livros-texto de algoritmos (CLRS). As
implementações deste repositório usam a convenção **0-based** nativa do
Java. As diferenças relevantes (por exemplo, os índices dos filhos em
Heap Sort) estão documentadas em comentário no início do arquivo.

## Versionamento

- **Versão utilizada na apostila atual:** `2026.1`
- Releases são marcadas com tags no formato `AAAA.S` (ano.semestre).
  A apostila sempre referencia uma tag específica — não o `main` — para
  garantir que o código consultado pelo estudante seja exatamente o que
  foi testado e revisado.
- Antes de cada semestre, os códigos são recompilados, testados e, se
  necessário, uma nova tag é publicada.

## Testando este repositório localmente antes de usar em sala

```bash
git clone https://github.com/pedrogcaliope/Construcao-Analise-Algoritmos.git
cd Construcao-Analise-Algoritmos
git checkout 2026.1
# rode o script "Executando tudo de uma vez" acima
```

## Licença

Distribuído sob a licença MIT (ver [`LICENSE`](LICENSE)) — livre para uso
educacional, com atribuição.

## Autoria e manutenção

Prof. Pedro Gabriel Calíope Dantas Pinheiro — Curso de Ciência da
Computação. Contribuições de estudantes são bem-vindas via *pull request*
(correções de bugs, testes adicionais, documentação); alterações no
comportamento dos algoritmos exigem revisão do professor antes do merge.
