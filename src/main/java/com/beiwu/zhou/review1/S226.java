package com.beiwu.zhou.review1;

import com.beiwu.zhou.TreeNode;

/**
 * @author zhoubing
 * @date 2021-03-30 17:42
 */
public class S226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public static void main(String[] args) {

    }
}
