package com.beiwu.zhou.exercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * add 是往尾部添加
 * pop 是从开始拿
 * @author zhoubing
 * @date 2021-03-22 13:55
 */
public class QueueExercise {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue);

        System.out.println("===================");
        queue.add(11);

        ((ArrayDeque<Integer>) queue).addFirst(35);
        System.out.println(queue);
    }
}
