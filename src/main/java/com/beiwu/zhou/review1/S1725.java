package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-03-25 00:47
 */
public class S1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int maxLength = 0;
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if (min > maxLength) {
                maxLength = min;
                count = 1;
            } else if (min == maxLength) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
