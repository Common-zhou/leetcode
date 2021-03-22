package com.beiwu.zhou.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implementation note: this implementation provides O(log(n)) time for the enqueuing
 * and dequeuing methods (offer, poll, remove() and add);
 *
 * linear time for the remove(Object) and contains(Object) methods;
 *
 * and constant time for the retrieval methods (peek, element, and size).
 * @author zhoubing
 * @date 2021-03-22 14:08
 */
public class PriorityQueueExercise {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        });

        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(9);
        priorityQueue.add(6);

        while (!priorityQueue.isEmpty()) {
            Integer elem = priorityQueue.poll();
            System.out.println(elem);
        }


        System.out.println(Arrays.toString( priorityQueue.toArray()));


    }
}
