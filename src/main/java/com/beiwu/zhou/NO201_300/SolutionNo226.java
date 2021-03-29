package com.beiwu.zhou.NO201_300;

import com.beiwu.zhou.TreeNode;

/**
 * @author zhoubing
 * @date 2021-03-29 11:38
 */
public class SolutionNo226 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;

    }
}
