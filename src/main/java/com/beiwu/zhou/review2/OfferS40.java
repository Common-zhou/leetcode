package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-06 11:05
 */
public class OfferS40 {

    /**
     * 排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);

        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void main(String[] args) {

    }
}
