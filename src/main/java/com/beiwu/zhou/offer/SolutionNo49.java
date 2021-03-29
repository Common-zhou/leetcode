package com.beiwu.zhou.offer;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-28 18:56
 */
public class SolutionNo49 {
    List<Integer> factor = Arrays.asList(1, 2, 3, 5);

    public boolean isUgly(int i) {

        if (factor.contains(i)) {
            return true;
        }
        while (true) {
            // 代表本次循环 是否有除尽
            boolean flag = false;
            for (int j = 1; j < factor.size(); j++) {
                if (i % factor.get(j) == 0) {
                    flag = true;
                    i = i / factor.get(j);
                }
            }
            if (factor.contains(i)) {
                return true;
            }
            if (!flag) {
                // 如果本次没有除  那就代表没法除尽
                return false;
            }
        }

    }

    public int nthUglyNumber(int n) {
        int length = 0;
        int number = 0;

        int i = 1;
        while (length < n) {
            boolean ugly = isUgly(i);
            if (ugly) {
                // 如果是 那就存储这个值
                length++;
                number = i;
            }
            i++;
        }

        return number;
    }


    public int nthUglyNumber2(int n) {
        int[] res = new int[n + 1];

        res[0] = 1;
        int a = 1, b = 1, c = 1;
        while (true) {
            int uglyNumber = min(res[a] * 2, res[b] * 3, res[c] * 5);
            
        }

    }

    private int min(int i, int i1, int i2) {
        if (i <= i1 && i <= i2) {
            return i;
        }
        if (i1 <= i && i1 <= i2) {
            return i1;
        }
        return i2;
    }

    public static void main(String[] args) {
        SolutionNo49 solutionNo49 = new SolutionNo49();
        //for (int i = 1; i < 10; i++) {
        //    boolean ugly = solutionNo49.isUgly(i);
        //    System.out.println(i + "===" + ugly);
        //}

        System.out.println(solutionNo49.nthUglyNumber(50));
    }
}
