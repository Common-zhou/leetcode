package com.beiwu.zhou.review1;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 *
 * @author zhoubing
 * @date 2021-03-21 16:30
 */
public class S11 {
    /**
     * 暴力法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int curArea = (j - i) * (Math.min(height[i], height[j]));
                maxArea = Math.max(maxArea, curArea);
            }
        }


        return maxArea;
    }

    /**
     * 夹逼法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int curArea = (right - left) * (Math.min(height[left], height[right]));
            maxArea = Math.max(curArea, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;

    }


    public static void main(String[] args) {

        S11 s11 = new S11();

        System.out.println(s11.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(s11.maxArea2(new int[]{1,1}));
    }
}
