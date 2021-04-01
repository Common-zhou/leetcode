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
        // 要求求全排列 代表什么?  代表有一个标识是否选择的函数
        boolean[] selected = new boolean[nums.length];
        Deque<Integer> deque = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();
        backstrack(nums, selected, deque, res);
        return res;
    }

    private void backstrack(int[] nums, boolean[] selected, Deque<Integer> deque,
                            List<List<Integer>> res) {
        // terminal
        if (deque.size() == nums.length) {
            // 如果选择的已经全了
            res.add(new ArrayList<>(deque));
        }

        // process data
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置没有选
            if (!selected[i]){
                // 如果没有选过
                selected[i] = true;
                deque.addLast(nums[i]);
                backstrack(nums, selected, deque, res);
                deque.removeLast();
                selected[i] = false;
            }
        }

        // drill down

        // reverse data
    }

    public static void main(String[] args) {
        S46 s46 = new S46();
        List<List<Integer>> res = s46.permute(new int[] {1, 2, 3});
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
