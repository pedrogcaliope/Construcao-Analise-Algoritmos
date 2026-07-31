import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    static void selectionSortComTraco(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
            System.out.printf("  passo %d  minimo %-3d  %s%n", i + 1, a[i], Arrays.toString(a));
        }
    }

    static boolean estaOrdenado(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        System.out.println("\n\u25B8 Selection Sort");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {5, 3, 8, 1, 9};
        System.out.println("Entrada  " + Arrays.toString(entrada));
        System.out.println();
        int[] resultado = entrada.clone();
        selectionSortComTraco(resultado);
        System.out.println();
        System.out.println("Ordenado " + Arrays.toString(resultado));

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{1, 3, 5, 8, 9});

        selectionSort(new int[]{});

        int[] ordemReversa = {9, 7, 5, 3, 1};
        selectionSort(ordemReversa);
        assert estaOrdenado(ordemReversa);

        int[] repetidos = {4, 2, 4, 1, 2};
        selectionSort(repetidos);
        assert estaOrdenado(repetidos);
    }
}
