package com.beiwu.zhou.review1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-04-01 23:22
 */
public class S169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countNum = countNums(nums);

        int max = 0;
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : countNum.entrySet()) {
            if (entry.getValue() > max){
                max = entry.getValue();
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer number = map.getOrDefault(num, 0);
            map.put(num, number + 1);
        }
        return map;
    }


    public static void main(String[] args) {
        S169 s169 = new S169();
        int i = s169.majorityElement(new int[]{1, 2, 3, 2, 3, 2, 2, 5});
        System.out.println(i);
    }
}
