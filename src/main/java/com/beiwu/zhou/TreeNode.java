package com.beiwu.zhou;

/**
 * @author zhoubing
 * @date 2021-03-26 11:44
 */
public class TreeNode {
    TreeNode left, right;
    int val;


    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public static void main(String[] args) {

    }
}
