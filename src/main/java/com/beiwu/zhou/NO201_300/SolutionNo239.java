package com.beiwu.zhou.NO201_300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 对于「最大值」，我们可以想到一种非常合适的数据结构，那就是优先队列（堆），其中的大根堆可以帮助我们实时维护一系列元素中的最大值。
 * <p>
 * 对于本题而言，初始时，我们将数组 \textit{nums}nums 的前 kk 个元素放入优先队列中。每当我们向右移动窗口时，
 * 我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。
 * 然而这个最大值可能并不在滑动窗口中，在这种情况下，这个值在数组 \textit{nums}nums 中的位置出现在滑动窗口左边界的左侧。
 * 因此，当我们后续继续向右移动窗口时，这个值就永远不可能出现在滑动窗口中了，我们可以将其永久地从优先队列中移除。
 * <p>
 * 我们不断地移除堆顶的元素，直到其确实出现在滑动窗口中。此时，堆顶元素就是滑动窗口中的最大值。为了方便判断堆顶元素与滑动窗口的位置关系，我们可以在优先队列中存储二元组 (\textit{num}, \textit{index})(num,index)，表示元素 \textit{num}num 在数组中的下标为 \textit{index}index。
 *
 * @author zhoubing
 * @date 2021-03-24 13:53
 */
public class SolutionNo239 {

    /**
     * 暴力解法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n+k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {

        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }

            result[i] = max;
        }

        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length < k) {
            return new int[0];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        // 将前k -1个元素 放到里面
        for (int i = 0; i < k - 1; i++) {
            pq.add(new int[]{nums[i], i});
        }

        int[] results = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});

            int left = i - k + 1;
            while (!pq.isEmpty()) {
                int[] tmpOne = pq.peek();
                if (tmpOne[1] < left) {
                    pq.poll();
                    continue;
                } else {
                    // 在范围之内 最大的
                    results[left] = tmpOne[0];
                    break;
                }
            }
        }

        return results;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                // 当新插入的数 比原数组末尾的要大时 不断的弹栈 直到它不是最大的
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                // 当新插入的数 比原数组末尾的要大时 不断的弹栈 直到它不是最大的
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }


    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow4(int[] nums, int k) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k - 1; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            priorityQueue.add(new int[]{nums[i], i});
            int left = i - k + 1;
            while (priorityQueue.peek()[1] < left) {
                priorityQueue.poll();
            }
            res[left] = priorityQueue.peek()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionNo239 solution = new SolutionNo239();
        int[] ints = solution.maxSlidingWindow4(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        System.out.println(Arrays.toString(ints));
    }
}
