public class MatrizCadeia {

    static class Resultado {
        int[][] m, s;
        int n;
    }

    // p[0..n]: a matriz A_i tem dimensao p[i-1] x p[i]
    static Resultado matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int custo = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (custo < m[i][j]) {
                        m[i][j] = custo;
                        s[i][j] = k;
                    }
                }
            }
        }

        Resultado r = new Resultado();
        r.m = m;
        r.s = s;
        r.n = n;
        return r;
    }

    static Resultado matrixChainOrderComTraco(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int l = 2; l <= n; l++) {
            StringBuilder linha = new StringBuilder("  cadeias de tamanho " + l + ": ");
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int custo = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (custo < m[i][j]) {
                        m[i][j] = custo;
                        s[i][j] = k;
                    }
                }
                linha.append("m[").append(i).append(",").append(j).append("]=").append(m[i][j]).append("  ");
            }
            System.out.println(linha);
        }

        Resultado r = new Resultado();
        r.m = m;
        r.s = s;
        r.n = n;
        return r;
    }

    static String parentizacaoOtima(int[][] s, int i, int j) {
        if (i == j) return "A" + i;
        return "(" + parentizacaoOtima(s, i, s[i][j]) + parentizacaoOtima(s, s[i][j] + 1, j) + ")";
    }

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        System.out.println("\n\u25B8 Multiplicacao de Cadeia de Matrizes");
        System.out.println("\u2500".repeat(40));

        int[] p = {30, 35, 15, 5, 10, 20, 25};
        System.out.println("Dimensoes p = " + java.util.Arrays.toString(p));
        System.out.println();
        Resultado r = matrixChainOrderComTraco(p);
        String parens = parentizacaoOtima(r.s, 1, r.n);

        System.out.println();
        System.out.println("Custo minimo:       " + r.m[1][r.n]);
        System.out.println("Parentizacao otima: " + parens);

        assert r.m[1][r.n] == 15125;
        assert parens.equals("((A1(A2A3))((A4A5)A6))");

        int[] p2 = {10, 100, 5, 50};
        Resultado r2 = matrixChainOrder(p2);
        assert r2.m[1][3] == 7500;
    }
}
