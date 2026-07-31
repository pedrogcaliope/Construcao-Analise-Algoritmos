import java.util.Arrays;

public class BubbleSort {

    static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break; // ja esta ordenado
        }
    }

    static void bubbleSortComTraco(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    trocou = true;
                }
            }
            System.out.printf("  passada %d  %s%n", i + 1, Arrays.toString(a));
            if (!trocou) break;
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

        System.out.println("\n\u25B8 Bubble Sort");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {8, 2, 3, 5, 1};
        System.out.println("Entrada  " + Arrays.toString(entrada));
        System.out.println();
        int[] resultado = entrada.clone();
        bubbleSortComTraco(resultado);
        System.out.println();
        System.out.println("Ordenado " + Arrays.toString(resultado));

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{1, 2, 3, 5, 8});

        bubbleSort(new int[]{});

        int[] jaOrdenado = {1, 2, 3, 4, 5};
        bubbleSort(jaOrdenado);
        assert estaOrdenado(jaOrdenado);

        int[] ordemReversa = {5, 4, 3, 2, 1};
        bubbleSort(ordemReversa);
        assert estaOrdenado(ordemReversa);
    }
}
