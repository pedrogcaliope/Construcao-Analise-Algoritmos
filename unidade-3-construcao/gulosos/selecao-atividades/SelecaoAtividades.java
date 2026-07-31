import java.util.ArrayList;
import java.util.List;

// Pre-condicao: atividades ja ordenadas por tempo de termino crescente.
public class SelecaoAtividades {

    record Atividade(int indice, int inicio, int fim) {
    }

    static List<Atividade> selecionarAtividades(List<Atividade> atividades) {
        List<Atividade> escolhidas = new ArrayList<>();
        if (atividades.isEmpty()) return escolhidas;

        Atividade ultima = atividades.get(0);
        escolhidas.add(ultima);

        for (int m = 1; m < atividades.size(); m++) {
            Atividade candidata = atividades.get(m);
            if (candidata.inicio() >= ultima.fim()) {
                escolhidas.add(candidata);
                ultima = candidata;
            }
        }
        return escolhidas;
    }

    static List<Atividade> selecionarComTraco(List<Atividade> atividades) {
        List<Atividade> escolhidas = new ArrayList<>();
        if (atividades.isEmpty()) return escolhidas;

        Atividade ultima = atividades.get(0);
        escolhidas.add(ultima);
        System.out.printf("  a%d [%d,%d)  \u2713 aceita (primeira)%n", ultima.indice(), ultima.inicio(), ultima.fim());

        for (int m = 1; m < atividades.size(); m++) {
            Atividade c = atividades.get(m);
            if (c.inicio() >= ultima.fim()) {
                escolhidas.add(c);
                System.out.printf("  a%d [%d,%d)  \u2713 aceita%n", c.indice(), c.inicio(), c.fim());
                ultima = c;
            } else {
                System.out.printf("  a%d [%d,%d)  \u2717 conflita com a%d%n", c.indice(), c.inicio(), c.fim(), ultima.indice());
            }
        }
        return escolhidas;
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        int[] s = {1, 2, 4, 1, 5, 8, 9, 11, 13};
        int[] f = {3, 5, 7, 8, 9, 10, 11, 14, 16};

        List<Atividade> atividades = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            atividades.add(new Atividade(i + 1, s[i], f[i]));
        }

        System.out.println("\n\u25B8 Selecao de Atividades");
        System.out.println("\u2500".repeat(40));
        List<Atividade> escolhidas = selecionarComTraco(atividades);
        System.out.println("\nEscolhidas: " + escolhidas.size() + " de " + atividades.size());

        assert escolhidas.size() == 4;

        boolean compativel = true;
        for (int i = 1; i < escolhidas.size(); i++) {
            if (escolhidas.get(i).inicio() < escolhidas.get(i - 1).fim()) compativel = false;
        }
        assert compativel;

        assert selecionarAtividades(List.of()).isEmpty();
        assert selecionarAtividades(List.of(new Atividade(1, 0, 5))).size() == 1;
    }
}
