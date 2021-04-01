package com.beiwu.zhou.review2;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.addLast(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.addLast(val);
        minStack.addLast(Math.min(val, minStack.peekLast()));
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
