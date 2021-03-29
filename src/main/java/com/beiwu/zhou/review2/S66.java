package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author zhoubing
 * @date 2021-03-29 17:49
 */
public class S66 {
    public int[] plusOne(int[] digits) {
        int carry = 0;

        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i >= 0; i--) {
            int res = digits[i] + carry;
            carry = res / 10;
            digits[i] = (res) % 10;
        }

        if (carry == 0) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = carry;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;

    }


    public static void main(String[] args) {
        S66 s66 = new S66();
        int[] ints = s66.plusOne(new int[] {9, 9, 9, 9});
        System.out.println(Arrays.toString(ints));
    }
}
