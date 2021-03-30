package com.beiwu.zhou.NO0_100;

/**
 * @author zhoubing
 * @date 2021-03-30 15:49
 */
public class SolutionNo50 {
    /**
     * 暴力法 循环
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }

        return res;
    }


    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = pow(x, n / 2);
        if (n % 2 != 0) {
            return res * res * x;
        } else {
            return res * res;
        }
    }

    public static void main(String[] args) {
        SolutionNo50 solution = new SolutionNo50();
        System.out.println(solution.myPow2(2, 10));
    }
}
