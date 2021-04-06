package com.beiwu.zhou.review2;

import com.beiwu.zhou.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-04-06 14:27
 */
public class S105 {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft,
                          int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        // 1. 找到先序的第一个在中序的位置  index
        Integer inOrderIndex = map.get(preorder[preLeft]);

        // 创建根节点
        TreeNode root = new TreeNode(preorder[preLeft]);

        // 前序的左子树长度 == 中序的左子树长度
        int length = inOrderIndex - inLeft;

        // 2. 构造左子树
        root.left =
            build(preorder, inorder, preLeft + 1, preLeft + length, inLeft, inOrderIndex - 1);

        // 3.构造右子树
        root.right =
            build(preorder, inorder, preLeft + length + 1, preRight, inOrderIndex + 1, inRight);

        // 4. 构造
        return root;

    }

    public static void main(String[] args) {

    }
}
