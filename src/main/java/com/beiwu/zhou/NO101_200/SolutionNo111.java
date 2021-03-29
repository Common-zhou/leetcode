package com.beiwu.zhou.NO101_200;

import com.beiwu.zhou.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-03-29 13:57
 */
public class SolutionNo111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left != null) {
            return minDepth(root.left) + 1;
        } else {
            return minDepth(root.right) + 1;
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int depth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return depth;

    }


    public static void main(String[] args) {

    }
}
