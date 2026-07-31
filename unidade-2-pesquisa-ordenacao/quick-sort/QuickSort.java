import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    static final Random RNG = new Random(42); // seed fixa: saida reproduzivel

    static void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    // Esquema de Lomuto, pivo = a[r]
    static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (a[j] <= x) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    static void quickSortComTraco(int[] a, int p, int r, int prof) {
        if (p >= r) return;
        int pivo = a[r];
        int q = partition(a, p, r);
        String indent = "  ".repeat(prof + 1);
        System.out.printf("%spivo %-3d  %s%n", indent, pivo, Arrays.toString(Arrays.copyOfRange(a, p, r + 1)));
        quickSortComTraco(a, p, q - 1, prof + 1);
        quickSortComTraco(a, q + 1, r, prof + 1);
    }

    static void randomizedQuickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(a, p, r);
            randomizedQuickSort(a, p, q - 1);
            randomizedQuickSort(a, q + 1, r);
        }
    }

    static int randomizedPartition(int[] a, int p, int r) {
        swap(a, r, p + RNG.nextInt(r - p + 1));
        return partition(a, p, r);
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void quickSort(int[] a) {
        if (a.length > 1) quickSort(a, 0, a.length - 1);
    }

    static void randomizedQuickSort(int[] a) {
        if (a.length > 1) randomizedQuickSort(a, 0, a.length - 1);
    }

    static boolean estaOrdenado(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        System.out.println("\n\u25B8 Quicksort");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.println("Entrada  " + Arrays.toString(entrada));
        System.out.println();
        int[] resultado = entrada.clone();
        quickSortComTraco(resultado, 0, resultado.length - 1, 0);
        System.out.println();
        System.out.println("Ordenado " + Arrays.toString(resultado));

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        int[] resultadoRand = entrada.clone();
        randomizedQuickSort(resultadoRand);
        assert estaOrdenado(resultadoRand);

        quickSort(new int[]{});

        int[] piorCaso = {1, 2, 3, 4, 5, 6, 7, 8};
        quickSort(piorCaso);
        assert estaOrdenado(piorCaso);

        int[] repetidos = {4, 2, 4, 1, 2, 4};
        quickSort(repetidos);
        assert estaOrdenado(repetidos);
    }
}
