package com.beiwu.zhou.NO101_200;

import com.beiwu.zhou.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-03-29 15:52
 */
public class SolutionNo105 {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight,
                                int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight || inorderLeft > inorderRight) {
            return null;
        }
        // 前序的第一个 一定是一个TreeNode
        TreeNode root = new TreeNode(preorder[preorderLeft]);

        // 这是根节点在中序 序列上的下标
        Integer rootIndex = indexMap.get(preorder[preorderLeft]);


        // 前序 应当计算inorder 到rootIndex的size
        int leftSize = rootIndex - inorderLeft + 1;

        int newPreRightIndex = preorderLeft + leftSize - 1;

        // 中序应当从  主要记住一个 两个序列的长度应该是相等的
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, newPreRightIndex, inorderLeft,
            rootIndex - 1);

        root.right =
            myBuildTree(preorder, inorder, newPreRightIndex + 1, preorderRight, rootIndex + 1,
                inorderRight);
        return root;

    }


    public static void main(String[] args) {
        SolutionNo105 solution = new SolutionNo105();
        //前序遍历 preorder = [3,9,20,15,7]
        //中序遍历 inorder = [9,3,15,20,7]
        TreeNode treeNode =
            solution.buildTree(new int[] {1, 2, 3}, new int[] {2, 3, 1});

        System.out.println(treeNode);
    }
}
