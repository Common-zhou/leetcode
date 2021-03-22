package com.beiwu.zhou.exercise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhoubing
 * @date 2021-03-22 14:03
 */
public class DequeExercise {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        System.out.println(deque);

        System.out.println(deque.remove());

        System.out.println(deque);

        deque.addLast(11);
        deque.addLast(22);
        deque.addLast(33);
        System.out.println(deque);

    }
}
