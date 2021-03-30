package com.beiwu.zhou.review1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhoubing
 * @date 2021-03-30 17:05
 */
public class S347 {

    public Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // key是 数 value是count
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        return map;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = countNums(nums);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return 1;
                }
                return -1;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[] {entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] poll = priorityQueue.poll();
            res[i] = poll[0];
        }

        return res;

    }

    public static void main(String[] args) {

    }
}
