import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    static void merge(int[] a, int p, int q, int r) {
        int[] left = Arrays.copyOfRange(a, p, q + 1);
        int[] right = Arrays.copyOfRange(a, q + 1, r + 1);

        int i = 0, j = 0, k = p;
        while (i < left.length && j < right.length) {
            a[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) a[k++] = left[i++];
        while (j < right.length) a[k++] = right[j++];
    }

    static void mergeSort(int[] a) {
        if (a.length > 1) mergeSort(a, 0, a.length - 1);
    }

    static void mergeSortComTraco(int[] a, int p, int r, int prof) {
        if (p >= r) return;
        String indent = "  ".repeat(prof + 1);
        int q = (p + r) / 2;
        System.out.println(indent + Arrays.toString(Arrays.copyOfRange(a, p, r + 1)));
        mergeSortComTraco(a, p, q, prof + 1);
        mergeSortComTraco(a, q + 1, r, prof + 1);
        merge(a, p, q, r);
        System.out.println(indent + "-> " + Arrays.toString(Arrays.copyOfRange(a, p, r + 1)));
    }

    static boolean estaOrdenado(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        System.out.println("\n\u25B8 Merge Sort");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {6, 3, 5, 1, 8, 2, 4, 7};
        System.out.println("Entrada  " + Arrays.toString(entrada));
        System.out.println();
        int[] resultado = entrada.clone();
        mergeSortComTraco(resultado, 0, resultado.length - 1, 0);
        System.out.println();
        System.out.println("Ordenado " + Arrays.toString(resultado));

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        mergeSort(new int[]{});

        int[] umElemento = {42};
        mergeSort(umElemento);
        assert umElemento[0] == 42;

        int[] repetidos = {4, 2, 4, 1, 2, 4};
        mergeSort(repetidos);
        assert estaOrdenado(repetidos);
    }
}
