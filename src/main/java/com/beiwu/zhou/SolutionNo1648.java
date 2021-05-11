package com.beiwu.zhou;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhoubing
 * @date 2021-05-11 16:49
 */
public class SolutionNo1648 {
    public int maxProfit(int[] inventory, int orders) {
        // 用一个优先队列来存 每次都取最大的 之后-1 最终得到的就是最大的利润
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (int i : inventory) {
            priorityQueue.add(i);
        }

        Long profit = 0L;
        for (int i = 0; i < orders; i++) {
            Integer val = priorityQueue.poll();
            Integer nextNumber = priorityQueue.peek() == null ? 0 : priorityQueue.peek();

            int last = val - nextNumber;
            for (int j = 0; j < last && i < orders; j++) {
                i++;
                profit += val;
                val -= 1;
            }
            if (val != 1) {
                priorityQueue.add(val - 1);
            }
        }

        return (int) (profit % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        SolutionNo1648 no1648 = new SolutionNo1648();
        int maxProfit = no1648.maxProfit(new int[]{1000000000}, 1000000000);
        System.out.println(maxProfit);
    }

}
