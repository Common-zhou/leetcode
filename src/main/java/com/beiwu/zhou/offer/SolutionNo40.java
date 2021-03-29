package com.beiwu.zhou.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhoubing
 * @date 2021-03-28 18:59
 */
public class SolutionNo40 {

    public int[] getLeastNumbers(int[] arr, int k) {

        Arrays.sort(arr);

        return Arrays.copyOfRange(arr, 0, k);

    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 != o2) {
                    return o1 - o2;
                }
                return -1;
            }
        });

        for (int i : arr) {
            priorityQueue.add(i);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionNo40 solution = new SolutionNo40();
        int[] res = solution.getLeastNumbers(new int[]{3, 2, 1}, 2);
        System.out.println(Arrays.toString(res));
    }
}
