package com.beiwu.zhou.review2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhoubing
 * @date 2021-04-06 11:13
 */
public class S347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = countNums(nums);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return -1;
                }
                return 1;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[] {entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] topKitem = priorityQueue.remove();
            res[i] = topKitem[0];
        }
        return res;

    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        return map;
    }

    public static void main(String[] args) {

    }
}
