import java.util.Arrays;

// LSD, base 10. Requer chaves inteiras nao negativas.
public class RadixSort {

    static void radixSortLSD(int[] a) {
        if (a.length <= 1) return;
        int max = 0;
        for (int x : a) max = Math.max(max, x);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(a, exp);
        }
    }

    static void radixSortComTraco(int[] a) {
        if (a.length <= 1) return;
        int max = 0;
        for (int x : a) max = Math.max(max, x);

        String[] casa = {"unidades", "dezenas", "centenas", "milhares"};
        int passo = 0;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(a, exp);
            String nome = passo < casa.length ? casa[passo] : "10^" + passo;
            System.out.printf("  %-10s %s%n", nome, Arrays.toString(a));
            passo++;
        }
    }

    static void countingSortByDigit(int[] a, int exp) {
        int n = a.length;
        int[] c = new int[10];
        int[] b = new int[n];

        for (int x : a) c[(x / exp) % 10]++;
        for (int i = 1; i < 10; i++) c[i] += c[i - 1];
        for (int j = n - 1; j >= 0; j--) {
            int d = (a[j] / exp) % 10;
            b[c[d] - 1] = a[j];
            c[d]--;
        }
        System.arraycopy(b, 0, a, 0, n);
    }

    static boolean estaOrdenado(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        System.out.println("\n\u25B8 Radix Sort (LSD, base 10)");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {329, 457, 657, 839, 436, 720, 355};
        int[] resultado = entrada.clone();
        System.out.println("Entrada  " + Arrays.toString(entrada));
        System.out.println();
        radixSortComTraco(resultado);
        System.out.println();
        System.out.println("Ordenado " + Arrays.toString(resultado));

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{329, 355, 436, 457, 657, 720, 839});

        int[] entrada2 = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSortLSD(entrada2);
        assert estaOrdenado(entrada2);

        radixSortLSD(new int[]{});

        int[] umElemento = {7};
        radixSortLSD(umElemento);
        assert umElemento[0] == 7;

        int[] comZeros = {0, 5, 0, 3, 0};
        radixSortLSD(comZeros);
        assert Arrays.equals(comZeros, new int[]{0, 0, 0, 3, 5});
    }
}
