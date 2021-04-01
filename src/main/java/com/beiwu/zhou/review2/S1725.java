package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-01 15:26
 */
public class S1725 {

    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int max = 0;

        for (int[] rectangle : rectangles) {
            int lengthMin = Math.min(rectangle[0], rectangle[1]);
            if (lengthMin > max) {
                max = lengthMin;
                count = 1;
            } else if (lengthMin == max) {
                count++;
            }
        }
        return count;

    }


    public static void main(String[] args) {
        S1725 s1725 = new S1725();
        int count = s1725.countGoodRectangles(new int[][] {{5, 8}, {3, 9}, {5, 12}, {16, 5}});
        System.out.println(count);
    }
}
