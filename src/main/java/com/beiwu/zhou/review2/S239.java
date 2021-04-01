package com.beiwu.zhou.review2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zhoubing
 * @date 2021-04-01 15:47
 */
public class S239 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                }
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k - 1; i++) {
            priorityQueue.add(new int[] {nums[i], i});
        }

        for (int i = k - 1; i < nums.length; i++) {
            int left = i - k + 1;
            priorityQueue.add(new int[] {nums[i], i});
            while (priorityQueue.peek()[1] < left) {
                priorityQueue.poll();
            }

            result[left] = priorityQueue.peek()[0];
        }

        return result;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                // 如果后进的 还大于先进的 说明 最后的就不应该存在
                deque.pollLast();
            }
            deque.addLast(i);
        }

        for (int i = k - 1; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                // 如果后进的 还大于先进的 说明 最后的就不应该存在
                deque.pollLast();
            }
            deque.addLast(i);
            int left = i - k + 1;
            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }

            result[left] = nums[deque.peekFirst()];
        }

        return result;
    }


    public static void main(String[] args) {
        S239 s239 = new S239();
        int[] ints = s239.maxSlidingWindow2(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
