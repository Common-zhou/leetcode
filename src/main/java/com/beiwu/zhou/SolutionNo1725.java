package com.beiwu.zhou;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 * <p>
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 * <p>
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 * <p>
 * 返回可以切出边长为 maxLen 的正方形的矩形 数目 。
 *
 * @author zhoubing
 * @date 2021-03-23 15:44
 */
public class SolutionNo1725 {
    /**
     * 暴力法 时间复杂度O(n)
     * 空间复杂度 O(n)
     *
     * @param rectangles
     * @return
     */
    public int countGoodRectangles1(int[][] rectangles) {

        int maxLength = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            int maxL = Math.min(rectangle[0], rectangle[1]);
            // 获取最大的
            maxLength = Math.max(maxL, maxLength);
            list.add(maxL);
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == maxLength) {
                count++;
            }
        }

        return count;
    }

    public int countGoodRectangles2(int[][] rectangles) {
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            int maxL = Math.min(rectangle[0], rectangle[1]);
            if (maxL > maxLength) {
                maxLength = maxL;
                count = 1;
            } else if (maxL == maxLength) {
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        SolutionNo1725 s1725 = new SolutionNo1725();
        System.out
            .println(s1725.countGoodRectangles2(new int[][] {{2,3},{3,7},{4,3},{3,7}}));
    }

}
