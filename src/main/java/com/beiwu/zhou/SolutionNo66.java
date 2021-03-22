package com.beiwu.zhou;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author zhoubing
 * @date 2021-03-22 10:37
 */
public class SolutionNo66 {

    public int[] plusOne(int[] digits) {

        int bringNumber = 0;

        //将最后一位加1
        digits[digits.length - 1] = digits[digits.length - 1] + 1;

        // 处理是否有进位
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + bringNumber;
            bringNumber = 0;
            if (digits[i] / 10 != 0) {
                bringNumber = digits[i] / 10;
                // 有进位
                digits[i] = digits[i] % 10;
            }
        }

        if (bringNumber == 0) {
            // 没有进位 直接返回
            return digits;
        }

        int[] ints = new int[digits.length + 1];
        ints[0] = bringNumber;
        for (int i = 0; i < digits.length - 1; i++) {
            ints[i + 1] = digits[i];
        }

        return ints;
    }

    public static void main(String[] args) {
        SolutionNo66 solution = new SolutionNo66();
        int[] ints = solution.plusOne(new int[] {9, 9, 9, 9});
        System.out.println(Arrays.toString(ints));
    }
}
