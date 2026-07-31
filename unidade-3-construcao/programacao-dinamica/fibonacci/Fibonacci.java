import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    static long fibRecursivo(int n) {
        if (n <= 1) return n;
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    static long fibMemo(int n) {
        return fibMemo(n, new HashMap<>());
    }

    private static long fibMemo(int n, Map<Integer, Long> memo) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        long resultado = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, resultado);
        return resultado;
    }

    static long fibIterativo(int n) {
        if (n <= 1) return n;
        long penultimo = 0, ultimo = 1, atual = 1;
        for (int i = 2; i <= n; i++) {
            atual = ultimo + penultimo;
            penultimo = ultimo;
            ultimo = atual;
        }
        return atual;
    }

    static void barra(String rotulo, double ms) {
        int blocos = (int) Math.min(40, Math.max(1, ms));
        System.out.printf("  %-14s %8.2f ms  %s%n", rotulo, ms, "\u2588".repeat(blocos));
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        System.out.println("\n\u25B8 Fibonacci");
        System.out.println("\u2500".repeat(40));

        long inicio = System.nanoTime();
        long r1 = fibRecursivo(30);
        long fimRec = System.nanoTime();
        long r2 = fibMemo(30);
        long fimMemo = System.nanoTime();
        long r3 = fibIterativo(30);
        long fimIter = System.nanoTime();

        System.out.println("F(30) = " + r1 + "\n");
        barra("recursivo", (fimRec - inicio) / 1e6);
        barra("memoizacao", (fimMemo - fimRec) / 1e6);
        barra("iterativo", (fimIter - fimMemo) / 1e6);

        assert r1 == r2 && r2 == r3;
        assert fibRecursivo(10) == 55;
        assert fibMemo(10) == 55;
        assert fibIterativo(10) == 55;
    }
}
