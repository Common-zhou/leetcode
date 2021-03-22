package com.beiwu.zhou;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * @author zhoubing
 * @date 2021-03-22 17:09
 */
public class SolutionNo155 {

    static class MinStack {

        private Deque<Integer> deque;
        private PriorityQueue<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            deque = new LinkedList<>();
            min = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1 > o2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }

        public void push(int val) {
            deque.addLast(val);
            min.add(val);
        }

        public void pop() {
            Integer first = deque.removeLast();
            min.remove(first);
        }

        public int top() {
            return deque.peekLast();
        }

        public int getMin() {
            return min.peek();
        }


    }


    /**
     * 使用两个栈来存储
     * stack是正常存储
     * minStack存储的到目前为止最小的
     * 比如：
     * stack    [1,2,3,-1,6,-5]
     * minStack [1,1,1,-1,-1,-5]
     * 这样弹栈的时候同步弹栈 栈首的元素就是最小的
     */
    static class MinStack2 {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;


        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.addLast(val);
            // 谁小存谁
            minStack.addLast(Math.min(minStack.peekLast(), val));
        }

        public void pop() {
            stack.removeLast();
            minStack.removeLast();
        }

        public int top() {
            return stack.peekLast();
        }

        public int getMin() {
            return minStack.peekLast();
        }
    }

    public static void main(String[] args) {

        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

        MinStack2 minStack = new MinStack2();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());//12
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());//12
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
