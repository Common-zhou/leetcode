package com.beiwu.zhou.review1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author zhoubing
 * @date 2021-03-24 00:42
 */
public class MinStack {
    private Deque<Integer> deque = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack.addLast(Integer.MAX_VALUE);
    }

    public void push(int val) {
        deque.addLast(val);
        minStack.addLast(Math.min(minStack.peekLast(), val));
    }

    public void pop() {
        deque.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return deque.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }
}
