package com.beiwu.zhou.review1;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * 递归
 * 循环
 *
 * @author zhoubing
 * @date 2021-03-21 17:37
 */
public class S70 {

    /**
     * 递归  算不出来时间复杂度
     * 时间复杂度
     * 空间复杂度
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;

    }

    public static void main(String[] args) {
        S70 s70 = new S70();

        System.out.println(s70.climbStairs1(2));


        System.out.println(s70.climbStairs2(3));
        System.out.println(s70.climbStairs2(4));
    }
}
