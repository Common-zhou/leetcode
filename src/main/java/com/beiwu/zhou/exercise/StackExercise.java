package com.beiwu.zhou.exercise;

import java.util.Stack;

/**
 * push  压栈
 * pop 弹栈
 * peek  只取  不弹栈
 *
 * Last in First out:   LIFO
 * @author zhoubing
 * @date 2021-03-22 13:51
 */
public class StackExercise {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(11);
        stack.push(22);

        while (!stack.empty()){
            Integer elem = stack.pop();
            System.out.println(elem);
        }

        System.out.println("===============");
        stack.push(55);
        stack.push(76);
        System.out.println(stack.peek());
        System.out.println(stack.peek());


    }
}
