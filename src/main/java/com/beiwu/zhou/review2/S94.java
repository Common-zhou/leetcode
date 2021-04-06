package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-02 11:04
 */
public class S94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    public static void main(String[] args) {

    }
}
