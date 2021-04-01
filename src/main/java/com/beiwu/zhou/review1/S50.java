package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-01 22:48
 */
public class S50 {
    /**
     * 暴力求解
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

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
        if (x == 0) {
            return 0;
        }

        long newN = n;
        if (n < 0) {
            x = 1 / x;
            newN = -1*(long)n;
        }

        return fastPow(x, newN);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);

        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }


    public static void main(String[] args) {
        S50 s50 = new S50();
        double value = s50.myPow2(2.00000, -2147483648);
        System.out.println(value);


        System.out.println(-1 * -2147483648L);
    }


}
