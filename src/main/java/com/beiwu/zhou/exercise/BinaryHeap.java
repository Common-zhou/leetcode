package com.beiwu.zhou.exercise;

/**
 * @author zhoubing
 * @date 2021-03-26 18:15
 */
public class BinaryHeap {
    int[] nums;
    int length = 0;

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(4);

        heap.insert(1);
        heap.insert(3);
        heap.insert(2);
        heap.insert(6);

        System.out.println(heap.delete());

    }

    public BinaryHeap() {
        new BinaryHeap(4);
    }

    public BinaryHeap(int k) {
        nums = new int[k];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int kSon(int i, int k) {
        return (2 * i) + k;
    }

    public boolean insert(int value) {
        if (isFull()) {
            // 满了
            return false;
        }
        nums[length++] = value;
        heapifyUp(length - 1);
        return true;
    }

    public int delete() {
        if (isEmpty()) {
            // 为空
            return -1;
        }

        int tmp = nums[0];
        nums[0] = nums[length - 1];
        length--;

        heapifyDown(0);

        return tmp;
    }

    private void heapifyDown(int index) {

        int tmp = nums[index];
        while (index < length) {
            int maxLeafsIndex = maxLeafts(index);
            nums[index] = nums[maxLeafsIndex];
            index = maxLeafsIndex;
        }
        nums[index] = tmp;

    }

    private int maxLeafts(int index) {
        int oneSon = kSon(index, 1);
        int twoSon = kSon(index, 2);

        if (nums[oneSon] > nums[twoSon]) {
            return oneSon;
        }
        return twoSon;
    }

    /**
     * heap化  将当前元素挪到最上面
     *
     * @param index
     */
    private void heapifyUp(int index) {
        int tmp = nums[index];
        while (index > 0 && nums[parent(index)] < tmp) {
            // 如果大于0
            nums[index] = nums[parent(index)];
            index = parent(index);
        }
        nums[index] = tmp;
    }

    private boolean isFull() {
        return length == nums.length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

}
