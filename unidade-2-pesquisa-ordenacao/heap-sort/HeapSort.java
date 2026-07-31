import java.util.Arrays;

// Indices 0-based (a apostila usa pseudocodigo 1-based; aqui os filhos
// de i sao 2*i+1 e 2*i+2).
public class HeapSort {

    static void heapSort(int[] a) {
        int n = a.length;
        buildMaxHeap(a, n);
        for (int i = n - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            maxHeapify(a, 0, i);
        }
    }

    static void heapSortComTraco(int[] a) {
        int n = a.length;
        buildMaxHeap(a, n);
        System.out.println("  heap construido  " + Arrays.toString(a));
        for (int i = n - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            maxHeapify(a, 0, i);
            System.out.printf("  extrai %-3d  %s%n", temp, Arrays.toString(a));
        }
    }

    static void buildMaxHeap(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, n);
        }
    }

    static void maxHeapify(int[] a, int i, int heapSize) {
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;
        int maior = i;

        if (esq < heapSize && a[esq] > a[maior]) maior = esq;
        if (dir < heapSize && a[dir] > a[maior]) maior = dir;

        if (maior != i) {
            int temp = a[i];
            a[i] = a[maior];
            a[maior] = temp;
            maxHeapify(a, maior, heapSize);
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

        System.out.println("\n\u25B8 Heap Sort");
        System.out.println("\u2500".repeat(40));

        int[] entrada = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        System.out.println("Entrada  " + Arrays.toString(entrada));
        System.out.println();
        int[] resultado = entrada.clone();
        heapSortComTraco(resultado);
        System.out.println();
        System.out.println("Ordenado " + Arrays.toString(resultado));

        assert estaOrdenado(resultado);
        assert Arrays.equals(resultado, new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16});

        heapSort(new int[]{});

        int[] umElemento = {42};
        heapSort(umElemento);
        assert umElemento[0] == 42;

        int[] ordemReversa = {9, 7, 5, 3, 1};
        heapSort(ordemReversa);
        assert estaOrdenado(ordemReversa);
    }
}
