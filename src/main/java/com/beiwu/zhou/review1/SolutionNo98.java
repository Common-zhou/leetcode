package com.beiwu.zhou.review1;

import com.beiwu.zhou.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-30 17:53
 */
public class SolutionNo98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return checkValidBST(node.left, lower, node.val) &&
            checkValidBST(node.right, node.val, upper);
    }


    public boolean isValidBST1(TreeNode root) {
        //中序遍历
        List<Integer> res = inorder(root);

        for (int i = 1; i < res.size(); i++) {
            if (res.get(i - 1) >= res.get(i)) {
                return false;
            }
        }
        return true;

    }

    public List<Integer> inorder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        res.addAll(inorder(node.left));
        res.add(node.val);
        res.addAll(inorder(node.right));

        return res;
    }

    public static void main(String[] args) {

    }
}
