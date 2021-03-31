package com.beiwu.zhou.review1;

import com.beiwu.zhou.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-03-31 17:05
 */
public class S105 {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            // 存储值 和index的映射
            map.put(inorder[i], i);
        }

        return reBuild(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);

    }

    private TreeNode reBuild(int[] preorder, int[] inorder, int preIndexLeft, int preIndexRight,
                             int inIndexLeft, int inIndexRight) {
        // 递归结束条件
        if (preIndexLeft > preIndexRight || inIndexLeft > inIndexRight) {
            return null;
        }

        // 首先构造先序的第一个 因为它是
        int rootValue = preorder[preIndexLeft];
        TreeNode node = new TreeNode(rootValue);

        Integer inorderIndex = map.get(rootValue);
        int leftSize = inorderIndex - inIndexLeft + 1;

        int newPreRightIndex = preIndexLeft + leftSize - 1;

        node.left = reBuild(preorder, inorder,
            preIndexLeft + 1, newPreRightIndex, inIndexLeft, inorderIndex - 1);

        node.right = reBuild(preorder, inorder,
            newPreRightIndex + 1, preIndexRight, inorderIndex + 1, inIndexRight);

        return node;
    }


    public static void main(String[] args) {
        S105 s105 = new S105();
        //前序遍历 preorder = [3,9,20,15,7]
        //中序遍历 inorder = [9,3,15,20,7]
        TreeNode treeNode =
            s105.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
        System.out.println(treeNode.val);
    }
}
