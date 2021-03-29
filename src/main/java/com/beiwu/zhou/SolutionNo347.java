package com.beiwu.zhou;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @author zhoubing
 * @date 2021-03-28 19:47
 */
public class SolutionNo347 {

    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer frequent = map.getOrDefault(nums[i], 0);
            map.put(nums[i], frequent + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getKey();
            Integer frequent = entry.getValue();
            priorityQueue.offer(new int[]{value, frequent});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] valueAndFrequent = priorityQueue.poll();
            res[i] = valueAndFrequent[0];
        }

        return res;

    }


    public static void main(String[] args) {

    }
}
