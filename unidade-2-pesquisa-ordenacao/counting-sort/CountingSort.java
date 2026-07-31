import java.util.Arrays;

public class CountingSort {

    // Assume chaves em [0, k]
    static int[] countingSortNonNegative(int[] a, int k) {
        int n = a.length;
        int[] c = new int[k + 1];
        int[] b = new int[n];

        for (int x : a) c[x]++;
        for (int i = 1; i <= k; i++) c[i] += c[i - 1];

        // percorre de tras para frente para garantir estabilidade
        for (int j = n - 1; j >= 0; j--) {
            int x = a[j];
            b[c[x] - 1] = x;
            c[x]--;
        }
        return b;
    }

    // Mesma logica, mas expondo os vetores intermediarios para o trace.
    static int[] countingSortComTraco(int[] a, int k) {
        int n = a.length;
        int[] c = new int[k + 1];
        int[] b = new int[n];

        for (int x : a) c[x]++;
        System.out.println("  contagem    " + Arrays.toString(c));

        for (int i = 1; i <= k; i++) c[i] += c[i - 1];
        System.out.println("  cumulativo  " + Arrays.toString(c));

        for (int j = n - 1; j >= 0; j--) {
            int x = a[j];
            b[c[x] - 1] = x;
            c[x]--;
        }
        System.out.println("  saida       " + Arrays.toString(b));
        return b;
    }

    // Versao com offset: suporta chaves negativas
    static int[] countingSortWithOffset(int[] a) {
        if (a.length == 0) return new int[0];
        int min = a[0], max = a[0];
        for (int x : a) {
            if (x < min) min = x;
            if (x > max) max = x;
        }
        int shift = -min;
        int k = max - min;
        int[] c = new int[k + 1];
        int[] b = new int[a.length];

        for (int x : a) c[x + shift]++;
        for (int i = 1; i <= k; i++) c[i] += c[i - 1];
        for (int j = a.length - 1; j >= 0; j--) {
            int key = a[j] + shift;
            b[c[key] - 1] = a[j];
            c[key]--;
        }
        return b;
    }

    static boolean estaOrdenado(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        System.out.println("\n\u25B8 Counting Sort");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Entrada     " + Arrays.toString(entrada) + "  (k=8)");
        System.out.println();
        int[] resultado = countingSortComTraco(entrada, 8);

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{1, 2, 2, 3, 3, 4, 8});
        assert Arrays.equals(resultado, countingSortNonNegative(entrada, 8));

        int[] comNegativos = {-3, 5, -1, 0, 2, -3, 4};
        int[] resultadoOffset = countingSortWithOffset(comNegativos);
        assert estaOrdenado(resultadoOffset);
        assert Arrays.equals(resultadoOffset, new int[]{-3, -3, -1, 0, 2, 4, 5});
        assert countingSortWithOffset(new int[]{}).length == 0;
    }
}
