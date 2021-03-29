package com.beiwu.zhou.NO101_200;

import com.beiwu.zhou.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-03-29 13:39
 */
public class SolutionNo104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        int max = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            max++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }


        return max;
    }


    public static void main(String[] args) {

    }
}
