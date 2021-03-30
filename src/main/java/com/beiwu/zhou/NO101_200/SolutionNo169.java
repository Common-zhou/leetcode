package com.beiwu.zhou.NO101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-03-30 16:25
 */
public class SolutionNo169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int maxNumber = 0;

        for (int num : nums) {
            Integer number = map.getOrDefault(num, 0);

            if (number + 1 > max) {
                max = number + 1;
                maxNumber = num;
            }
            map.put(num, number + 1);
        }
        return maxNumber;

    }

    public static void main(String[] args) {

    }
}
