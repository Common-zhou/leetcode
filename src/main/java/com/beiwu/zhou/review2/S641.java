package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-01 16:55
 */
public class S641 {

    static class MyCircularDeque {

        // 在头插入 需要在front-1位置插入 在尾插入 需要在end位置插
        // 如果front == end 且 hasData = true  则代表满
        // 如果front == end 且 hasData = false  则代表空
        int[] data;
        int front, end;
        boolean hasData;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            data = new int[k];
            front = 0;
            end = 0;
            hasData = false;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                // 满了 插入失败
                return false;
            }
            int index = (front - 1 + data.length) % data.length;
            data[index] = value;
            front = index;
            hasData = true;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                // 满了 插入失败
                return false;
            }
            data[end] = value;
            end = (end + 1) % data.length;
            hasData = true;
            return true;
        }


        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                // 为空 删除失败
                return false;
            }
            front = (front + 1) % data.length;
            hasData = false;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                // 为空 删除失败
                return false;
            }
            end = (end - 1 + data.length) % data.length;
            hasData = false;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return data[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return data[(end - 1 + data.length) % data.length];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            if (front == end && !hasData) {
                return true;
            }
            return false;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            if (front == end && hasData) {
                return true;
            }
            return false;
        }
    }


    public static void main(String[] args) {
        MyCircularDeque circularDeque = new S641.MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());
    }
}
