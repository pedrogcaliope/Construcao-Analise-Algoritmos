import java.util.Arrays;

// moedas[] deve estar ordenado de forma decrescente.
// So garante otimo em sistemas canonicos (ex.: {25,10,5,1}).
public class Troco {

    static int[] trocoGuloso(int[] moedas, int x) {
        int[] qtd = new int[moedas.length];
        for (int i = 0; i < moedas.length; i++) {
            qtd[i] = x / moedas[i];
            x = x % moedas[i];
        }
        return qtd;
    }

    static int[] trocoGulosoComTraco(int[] moedas, int x) {
        int[] qtd = new int[moedas.length];
        int restante = x;
        for (int i = 0; i < moedas.length; i++) {
            qtd[i] = restante / moedas[i];
            restante %= moedas[i];
            if (qtd[i] > 0) {
                System.out.printf("  %dx moeda de %-3d  restam %d%n", qtd[i], moedas[i], restante);
            }
        }
        return qtd;
    }

    static int totalMoedas(int[] qtd) {
        int total = 0;
        for (int q : qtd) total += q;
        return total;
    }

    static int restante(int[] moedas, int[] qtd, int x) {
        int usado = 0;
        for (int i = 0; i < moedas.length; i++) usado += moedas[i] * qtd[i];
        return x - usado;
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        int[] sistemaCanonico = {25, 10, 5, 1};

        System.out.println("\n\u25B8 Troco Guloso");
        System.out.println("\u2500".repeat(40));
        System.out.println("Moedas   " + Arrays.toString(sistemaCanonico) + "   alvo = 92");
        System.out.println();
        int[] qtd1 = trocoGulosoComTraco(sistemaCanonico, 92);
        System.out.println("\nTotal: " + totalMoedas(qtd1) + " moedas");

        assert totalMoedas(qtd1) == 7;
        assert restante(sistemaCanonico, qtd1, 92) == 0;

        // Contraexemplo: sistema nao canonico onde o guloso falha
        int[] naoCanonico = {4, 3, 1};
        int[] qtd3 = trocoGuloso(naoCanonico, 6);
        System.out.println("\nContraexemplo -- moedas {4,3,1}, alvo = 6:");
        System.out.println("  guloso usa " + totalMoedas(qtd3) + " moedas " + Arrays.toString(qtd3)
                + ", mas o otimo seria 2 (3+3)");
        assert totalMoedas(qtd3) == 3;
    }
}
