package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;

/**
 * @author zhoubing
 * @date 2021-04-06 14:18
 */
public class S111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;

        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }

        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }

    public static void main(String[] args) {

    }


}
