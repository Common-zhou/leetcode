package com.beiwu.zhou.review2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-06 15:29
 */
public class S78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recurSub(nums, 0, new LinkedList<>(), res);
        return res;
    }

    public void recurSub(int[] nums, int index, Deque<Integer> deque, List<List<Integer>> res) {
        // terminal
        if (index == nums.length) {
            // 如果到达最后了
            res.add(new ArrayList<>(deque));
            return;
        }

        // process data + drill down
        // 选当前层数的数字
        deque.addLast(nums[index]);
        recurSub(nums, index + 1, deque, res);

        // reverse data
        deque.removeLast();
        //不选
        recurSub(nums, index + 1, deque, res);

    }

    public static void main(String[] args) {

    }
}
