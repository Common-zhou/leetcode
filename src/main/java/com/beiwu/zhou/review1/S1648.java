package com.beiwu.zhou.review1;

import java.util.Comparator;
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
            if (curVal.equals(priorityQueue.peek())) {
                // 如果当前值 等于 队头的值
                maxProfit = maxProfit + curVal;
                orders -= 1;
                if (curVal - 1 != 0) {
                    priorityQueue.add(curVal - 1);
                }

                continue;
            }


            // 否则 最多 卖出多少呢？ 卖出和队头的差值
            // 比如现在是 [10,8] 那最多可以买  10 ,9,8,7 相当于 是 10-8+2
            Long saleNum = curVal - priorityQueue.peek() + 2;
            saleNum = saleNum > orders ? orders : saleNum;
            Double curProfit = (curVal + curVal - saleNum + 1) / 2.0 * saleNum;
            maxProfit = maxProfit + curProfit.longValue();
            orders -= saleNum;

            if ((curVal - saleNum + 1) != 0) {
                priorityQueue.add((curVal - saleNum));
            }
        }

        return (int) (maxProfit % (Math.pow(10, 9) + 7));
    }


    public int maxProfit2(int[] inventory, int orders) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i : inventory) {
            priorityQueue.add((long) i);
        }

        Long maxProfit = 0L;

        while (orders > 0) {

            // 当剩余的大于0时
            Long curVal = priorityQueue.poll();
            // 分三种情况
            // 当前优先队列里只有一个元素了
            if (priorityQueue.isEmpty()) {
                Double curProfit = ((curVal + curVal - orders + 1) / 2.0 * orders);
                curProfit = curProfit % (Math.pow(10, 9) + 7);

                maxProfit = maxProfit +
                    curProfit.longValue();
                // 因为题目的意思是 orders一定是小于sum的
                orders = 0;
                continue;
            }

            // 当前优先队列里有多个元素 ： 尾部的和当前相等
            if (curVal.equals(priorityQueue.peek())) {
                // 如果相等 那就只取一个
                maxProfit = maxProfit + curVal;
                if ((curVal - 1) != 0) {
                    priorityQueue.add(curVal - 1);
                }
                orders -= 1;
                continue;
            }


            // 尾部的比当前小
            // 至少可以减到哪里 可以减到 和尾部小一个的位置
            int saleNum = (int) (curVal - priorityQueue.peek() + 1);

            // 对当前要卖出个数的确定  因为防止多卖
            saleNum = saleNum > orders ? orders : saleNum;
            long lastVal = curVal - saleNum + 1;
            maxProfit = maxProfit +
                ((Double) ((curVal + lastVal) / 2.0 * saleNum)).longValue();

            maxProfit = ((Double) (maxProfit % (Math.pow(10, 9) + 7))).longValue();

            if ((lastVal - 1) != 0) {
                priorityQueue.add(lastVal - 1);
            }

            orders -= saleNum;

        }
        return (int) (maxProfit % (Math.pow(10, 9) + 7));


    }

    public static void main(String[] args) {

        S1648 s1648 = new S1648();
        //System.out.println(s1648.maxProfit(new int[]{2, 5}, 4));
        //System.out.println(s1648.maxProfit(new int[]{3, 5}, 6));
        //[2,8,4,10,6]
        //20

        //System.out.println(s1648.maxProfit2(new int[] {2, 8, 4, 10, 6}, 20));
        //System.out.println(s1648.maxProfit(new int[] {1000, 1000}, 2));
        //[773160767]
        //252264991
        System.out.println(s1648.maxProfit(new int[] {773160767}, 252264991));
        System.out.println(s1648.maxProfit(new int[] {1000000000}, 1000000000));
        System.out.println(s1648.maxProfit2(new int[] {1000000000}, 1000000000));
    }


}
