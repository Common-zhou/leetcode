package com.beiwu.zhou;

/**
 * @author zhoubing
 * @date 2021-05-18 10:33
 */
public class SolutionNo1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0L;

        for (int num : nums) {
            sum += num;
        }
        long diff = goal - sum;
        diff = Math.abs(diff);

        long num = diff / (limit);
        long remain = diff % (limit);
        return remain != 0 ? (int) (num + 1) : (int) num;
    }

    public static void main(String[] args) {
        SolutionNo1785 solutionNo1785 = new SolutionNo1785();
        System.out.println(solutionNo1785.minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(solutionNo1785.minElements(new int[]{1, -10, 9, 1}, 100, 0));
        System.out.println(solutionNo1785.minElements(new int[]{-1,0,1,1,1}, 1, 771843707));

        //[-1,0,1,1,1]
        //1
        //771843707
    }


}
