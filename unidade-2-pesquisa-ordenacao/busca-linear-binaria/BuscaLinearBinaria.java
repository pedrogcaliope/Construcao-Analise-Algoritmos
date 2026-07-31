import java.util.Arrays;

public class BuscaLinearBinaria {

    static int pesquisaSequencial(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    static int buscaBinaria(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == x) return m;
            if (a[m] < x) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    static int buscaBinariaComTraco(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            System.out.printf("  intervalo [%d,%d]  meio=%d (valor %d)%n", l, r, m, a[m]);
            if (a[m] == x) {
                System.out.println("  encontrado no indice " + m);
                return m;
            }
            if (a[m] < x) l = m + 1;
            else r = m - 1;
        }
        System.out.println("  nao encontrado");
        return -1;
    }

    static int buscaBinariaRec(int[] a, int x, int l, int r) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;
        if (a[m] == x) return m;
        if (a[m] < x) return buscaBinariaRec(a, x, m + 1, r);
        return buscaBinariaRec(a, x, l, m - 1);
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        int[] ordenado = {2, 5, 8, 12, 16, 23, 38, 45};

        System.out.println("\n\u25B8 Busca Binaria");
        System.out.println("\u2500".repeat(40));
        System.out.println("Vetor    " + Arrays.toString(ordenado) + "   alvo = 23");
        System.out.println();
        int achado = buscaBinariaComTraco(ordenado, 23);

        assert achado == 5;
        assert buscaBinaria(ordenado, 23) == 5;
        assert buscaBinariaRec(ordenado, 23, 0, ordenado.length - 1) == 5;
        assert buscaBinaria(ordenado, 100) == -1;
        assert buscaBinaria(ordenado, 2) == 0;
        assert buscaBinaria(ordenado, 45) == ordenado.length - 1;

        int[] naoOrdenado = {31, 41, 59, 26, 41, 58};
        assert pesquisaSequencial(naoOrdenado, 26) == 3;
        assert pesquisaSequencial(naoOrdenado, 100) == -1;
    }
}
