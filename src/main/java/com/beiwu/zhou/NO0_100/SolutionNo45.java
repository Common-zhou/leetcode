package com.beiwu.zhou.NO0_100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-04-24 14:18
 */
public class SolutionNo45 {

    /**
     * 最好是更好的敌人 先做出来 再想办法优化
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Deque<Integer> deque = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        deque.addLast(0);
        visited[0] = true;

        int jump = 0;
        while (!deque.isEmpty()) {
            jump++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer head = deque.pollFirst();

                int jumpNumber = nums[head];
                if (head + jumpNumber >= nums.length - 1) {
                    return jump;
                }
                for (int j = 1; j <= jumpNumber; j++) {
                    if (!visited[head + j]) {
                        // 如果这位置没有路过
                        visited[head + j] = true;
                        deque.addLast(head + j);
                    }
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        SolutionNo45 solution = new SolutionNo45();
        int jump = solution.jump(new int[] {2, 1});
        System.out.println(jump);

    }
}
