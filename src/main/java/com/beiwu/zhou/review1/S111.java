package com.beiwu.zhou.review1;

import com.beiwu.zhou.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoubing
 * @date 2021-03-31 14:32
 */
public class S111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = min = Math.min(min, minDepth(root.left));
        }

        if (root.right != null) {
            min = min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }

    public int minDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        Deque<TreeNode> queue = new LinkedList<>();

        int depth = 0;
        queue.addLast(root);
        while (!queue.isEmpty()) {

            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left == null && node.right == null) {
                    // 说明这个是叶子
                    return depth;
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }


        return depth;
    }

    public static void main(String[] args) {

    }
}
