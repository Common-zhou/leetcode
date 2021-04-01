package com.beiwu.zhou.review1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-01 18:03
 */
public class S46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        backtrack(nums, selected, deque, res);

        return res;
    }

    private void backtrack(int[] nums, boolean[] selected, Deque<Integer> deque, List<List<Integer>> res) {
        // terminal
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        // process data
        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                // 如果当前元素已经被选过了
                continue;
            }
            selected[i] = true;
            deque.addLast(nums[i]);
            System.out.println("递归前："+ deque);
            backtrack(nums, selected, deque, res);
            deque.removeLast();
            System.out.println("递归后："+ deque);
            selected[i] = false;
        }

        // drill down

        //reverse data
    }

    public static void main(String[] args) {
        S46 s46 = new S46();
        List<List<Integer>> res = s46.permute(new int[]{1, 2, 3, 4});
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
