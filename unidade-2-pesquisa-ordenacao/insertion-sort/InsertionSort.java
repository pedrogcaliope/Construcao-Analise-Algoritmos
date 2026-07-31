import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
    }

    // Mesma logica acima, mas imprimindo o vetor a cada insercao.
    static void insertionSortComTraco(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
            System.out.printf("  passo %d  insere %-3d  %s%n", j, key, Arrays.toString(a));
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

        System.out.println("\n\u25B8 Insertion Sort");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {5, 2, 4, 6, 1, 3};
        System.out.println("Entrada  " + Arrays.toString(entrada));
        System.out.println();
        int[] resultado = entrada.clone();
        insertionSortComTraco(resultado);
        System.out.println();
        System.out.println("Ordenado " + Arrays.toString(resultado));

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{1, 2, 3, 4, 5, 6});

        insertionSort(new int[]{});

        int[] ordemReversa = {9, 7, 5, 3, 1};
        insertionSort(ordemReversa);
        assert estaOrdenado(ordemReversa);

        int[] repetidos = {4, 2, 4, 1, 2};
        insertionSort(repetidos);
        assert estaOrdenado(repetidos);
    }
}
