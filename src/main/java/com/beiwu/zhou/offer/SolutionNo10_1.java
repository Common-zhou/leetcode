package com.beiwu.zhou.offer;

/**
 * @author zhoubing
 * @date 2021-04-12 10:14
 */
public class SolutionNo10_1 {

    public int fib1(int n) {
        n = n % 1000000007;
        if (n == 0 || n == 1) {
            return n;
        }

        return fib1(n - 1) + fib1(n - 2);
    }


    public long fib2(int n) {
        //n = n % 1000000007;
        int left = 0;
        int right = 1;

        for (int i = 0; i < n; i++) {
            int next = left + right;
            left = right % 1000000007;
            right = next % 1000000007;
        }
        return (left % 1000000007);

    }


    public int fib(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        return fib(n, res) % 1000000007;
    }

    public int fib(int n, int[] res) {
        if (n == 0 || n == 1) {
            return res[n];
        }

        if (res[n] != 0) {
            return res[n];
        } else {
            // 当前位置还没排上
            res[n] = (fib(n - 1, res) + fib(n - 2, res)) % 1000000007;
            return res[n];
        }
    }

    public static void main(String[] args) {
        SolutionNo10_1 solution = new SolutionNo10_1();
        System.out.println(solution.fib2(95));
        System.out.println(solution.fib(0));
    }
}
