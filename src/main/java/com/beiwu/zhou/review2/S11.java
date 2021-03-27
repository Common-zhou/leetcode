package com.beiwu.zhou.review2;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * @author zhoubing
 * @date 2021-03-27 22:51
 */
public class S11 {
    /**
     * 暴力法 遍历宽
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        if (height.length < 2) {
            return 0;
        }
        int max = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, min * (j - i));
            }
        }

        return max;
    }

    /**
     * 双端
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * min);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }


        return max;
    }


    public static void main(String[] args) {
        S11 s11 = new S11();
        int area = s11.maxArea2(new int[]{4, 3, 2, 1, 4});
        System.out.println(area);
    }
}
