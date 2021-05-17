package com.beiwu.zhou.review1;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhoubing
 * @date 2021-05-17 17:52
 */
public class S1648 {

    public int maxProfit(int[] inventory, int orders) {

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o2, o1);
            }
        });

        for (int i : inventory) {
            priorityQueue.add((long) i);
        }
        Long maxProfit = 0L;

        while (orders > 0) {
            Long curVal = priorityQueue.poll();
            // 如果当前队列为空  那就一次卖完
            if (priorityQueue.isEmpty()) {
                Double curProfit = (curVal + curVal - orders + 1) / 2.0 * orders;
                maxProfit = maxProfit + curProfit.longValue();
                orders = 0;
                continue;
            }
            // 否则 最多 卖出多少呢？ 卖出和队头的差值
            Long saleNum = curVal - priorityQueue.peek() + 1;
            saleNum = saleNum > orders ? orders : saleNum;
            Double curProfit = (curVal + curVal - saleNum + 1) / 2.0 * saleNum;
            maxProfit = maxProfit + curProfit.longValue();
            orders -= saleNum;

            if ((curVal - saleNum + 1) != 0) {
                priorityQueue.add((curVal - saleNum + 1));
            }
        }

        return (int) (maxProfit % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {

        S1648 s1648 = new S1648();
        //System.out.println(s1648.maxProfit(new int[]{2, 5}, 4));
        //System.out.println(s1648.maxProfit(new int[]{3, 5}, 6));
        //[2,8,4,10,6]
        //20

        System.out.println(s1648.maxProfit(new int[]{2, 8, 4, 10, 6}, 20));
        //System.out.println(s1648.maxProfit(new int[]{1000000000}, 1000000000));
    }


}
