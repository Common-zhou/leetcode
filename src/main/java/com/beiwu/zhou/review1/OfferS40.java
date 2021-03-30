package com.beiwu.zhou.review1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author zhoubing
 * @date 2021-03-30 16:45
 */
public class OfferS40 {
    /**
     * 排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    /**
     * 优先队列
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int num : arr) {
            priorityQueue.add(num);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        OfferS40 offerS40 = new OfferS40();
        int[] leastNumbers1 = offerS40.getLeastNumbers2(new int[] {3, 2, 1}, 2);
        System.out.println(Arrays.toString(leastNumbers1));
    }
}
