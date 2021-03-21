package com.beiwu.zhou;

/**
 * 1.双指针 哪个小移动哪一个 最后计算出最大的面积
 * 2. 暴力法
 *
 * @author zhoubing
 * @date 2021-03-20 00:20
 */
public class SolutionNO11 {
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        SolutionNO11 solutionNO11 = new SolutionNO11();
        int max = solutionNO11.maxArea(new int[]{4, 3, 2, 1, 4});
        System.out.println(max);
    }
}
