package com.abyss.basics.programingModel;

/**
 * @author matth
 * @date 2018/9/9
 */
public class Binomial {
    private static double[][] M;

    private static double binomial(int n, int k, double p) {
        if (n == 0 && k == 0) {
            return 1.0;
        }
        if (n < 0 || k < 0) {
            return 0.0;
        }
        if (M[n][k] == -1) {
            // 对于没有计算过值的才计算，计算过的直接从数组中获取
            M[n][k] = (1.0 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
        }
        return M[n][k];
    }

    private static double getBinomial(int n, int k, double p) {
        M = new double[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                M[i][j] = -1;
            }
        }
        return binomial(n, k, p);
    }

    public static void main(String[] args) {
        System.out.println(getBinomial(10, 5, 0.25));
        System.out.println(getBinomial(20, 10, 0.25));
        System.out.println(getBinomial(30, 15, 0.25));
        System.out.println(getBinomial(50, 25, 0.25));
        System.out.println(getBinomial(100, 50, 0.25));
    }
}
