package com.beiwu.zhou.review1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 *
 * @author zhoubing
 * @date 2021-03-25 09:43
 */
public class S239 {

    /**
     * 暴力法
     * 时间复杂度 O(n*k) = O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int[] ints = new int[nums.length - k + 1];

        // k-1 到末尾
        for (int i = k - 1; i < nums.length; i++) {
            // 从k位置开始
            int left = i - k + 1;
            int max = Integer.MIN_VALUE;
            for (int j = left; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            ints[left] = max;
        }
        return ints;
    }

    /**
     * 采用优先队列实现
     * 时间复杂度 O(n log(n))
     * 空间复杂度 O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.add(new int[] {nums[i], i});
        }

        int[] ints = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            pq.add(new int[] {nums[i], i});
            // 最小的边界是 i-k+1
            int left = i - k + 1;
            while (!pq.isEmpty() && pq.peek()[1] < left) {
                pq.poll();
            }
            // 现在就是符合的
            ints[left] = pq.peek()[0];
        }

        return ints;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                // 如果插入的元素大于队列尾部的 说明队列尾部的就没有必要存在
                deque.pollLast();
            }
            deque.addLast(i);
        }

        int[] result = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            // 首先加入队尾
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                // 如果插入的元素大于队列尾部的 说明队列尾部的就没有必要存在
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

        int[] ints = s239.maxSlidingWindow3(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
