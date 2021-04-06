package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;

/**
 * @author zhoubing
 * @date 2021-04-06 11:34
 */
public class S226 {
    public TreeNode invertTree(TreeNode root) {
        // terminal
        if (root == null) {
            return root;
        }

        // process data
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        // drill down

        // reverse data

        return root;
    }

    public static void main(String[] args) {

    }
}
