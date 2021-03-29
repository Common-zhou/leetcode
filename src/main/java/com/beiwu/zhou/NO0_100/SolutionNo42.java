package com.beiwu.zhou.NO0_100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * @author zhoubing
 * @date 2021-03-24 16:08
 */
public class SolutionNo42 {

    /**
     * 它一次只记录当前柱子积的水
     * 并且从当前柱子出发  找到比当前柱子搞得  然后积累
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int ans = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }

        return ans;
    }

    /**
     * 我们可以不用像方法 2 那样存储最大高度，而是用栈来跟踪可能储水的最长的条形块。使用栈就可以在一次遍历内完成计算。
     * <p>
     * 我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到 \text{ans}ans 。
     * <p>
     * 算法
     * <p>
     * 使用栈来存储条形块的索引下标。
     * 遍历数组：
     * 当栈非空且 \text{height}[current]>\text{height}[st.top()]height[current]>height[st.top()]
     * 意味着栈中元素可以被弹出。弹出栈顶元素 \text{top}top。
     * 计算当前元素和栈顶元素的距离，准备进行填充操作
     * \text{distance} = \text{current} - \text{st.top}() - 1distance=current−st.top()−1
     * 找出界定高度
     * \text{bounded\_height} = \min(\text{height[current]}, \text{height[st.top()]}) - \text{height[top]}bounded_height=min(height[current],height[st.top()])−height[top]
     * 往答案中累加积水量\text{ans} \mathrel{+}= \text{distance} \times \text{bounded\_height}ans+=distance×bounded_height
     * 将当前索引下标入栈
     * 将 \text{current}current 移动到下个位置
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int current = 0; current < height.length; current++) {
            while (!deque.isEmpty() && height[current] > height[deque.peekLast()]) {
                Integer top = deque.pollLast();
                if (deque.isEmpty()){
                    break;
                }
                int h = Math.min(height[current], height[deque.peekLast()]) - height[top];
                int w = current - deque.peekLast() - 1;
                ans += h * w;
            }
            deque.addLast(current);
        }

        return ans;
    }

    public int trap_official(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }



    public static void main(String[] args) {
        SolutionNo42 solution = new SolutionNo42();
        int result = solution.trap2(new int[] {4, 2, 0, 3, 2, 5});
        System.out.println(result);
    }
}
