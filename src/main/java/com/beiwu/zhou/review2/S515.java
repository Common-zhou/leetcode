package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-04-13 12:53
 */
public class S515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                max = Math.max(node.val, max);

                if (node.left != null){
                    deque.addLast(node.left);
                }
                if (node.right != null){
                    deque.addLast(node.right);
                }
            }
            res.add(max);
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
