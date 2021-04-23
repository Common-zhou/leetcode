package com.beiwu.zhou.review2;

import java.util.Arrays;

/**
 * @author zhoubing
 * @date 2021-04-21 00:09
 */
public class S455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index1 = 0;
        int index2 = 0;


        while (index1 < g.length && index2 < s.length) {
            if (g[index1] <= s[index2]){
                // 如果小孩子的胃口值 小于等于饼干的尺寸 代表可以成功
                index1++;
                index2++;
            }else{
                index2++;
            }
        }
        return index1;

    }

}
