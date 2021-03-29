package com.beiwu.zhou.NO201_300;

import com.beiwu.zhou.TreeNode;
import com.beiwu.zhou.utils.TreeNodeUtils;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-29 14:13
 */
public class SolutionNo297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                res.add(node.val);
                queue.addLast(node.left);
                queue.addLast(node.right);
            } else {
                res.add(null);
            }
        }

        System.out.println(res);


        return res.toString().replace(" ", "");
    }

    //public String preOrder(TreeNode node) {
    //    if (node == null) {
    //        return "null";
    //    }
    //    StringBuilder sb = new StringBuilder();
    //
    //    sb.append(node.val).append(",");
    //    sb.append(preOrder(node.left)).append(",");
    //
    //    sb.append(preOrder(node.right)).append(",");
    //    return sb.toString();
    //}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Integer[] nums = convertString2Nums(data);

        if (nums == null || nums.length == 0){
            return null;
        }


        TreeNode node = new TreeNode(nums[0]);

        Deque<TreeNode> queue = new LinkedList<>();

        queue.addLast(node);

        int i = 0;
        while (i < nums.length && !queue.isEmpty()) {
            TreeNode curNode = queue.removeFirst();

            if ((i * 2 + 1) < nums.length) {
                Integer leftNum = nums[i * 2 + 1];
                if (leftNum != null) {
                    curNode.left = new TreeNode(leftNum);
                    queue.addLast(curNode.left);
                }
            }

            if ((i * 2 + 2) < nums.length) {
                Integer rightNum = nums[i * 2 + 2];

                if (rightNum != null) {
                    curNode.right = new TreeNode(rightNum);
                    queue.addLast(curNode.right);
                }
            }


            i++;
        }
        return node;
    }

    private Integer[] convertString2Nums(String data) {

        if ("[]".equals(data)) {
            return new Integer[0];
        }

        String[] dataArray = data.replace("[", "").replace("]", "").split(",");


        int length = dataArray.length - 1;
        while (length > 0) {
            if ("null".equals(dataArray[length])) {
                length--;
            } else {
                break;
            }
        }

        Integer[] nums = new Integer[length + 1];
        for (int i = 0; i < length + 1; i++) {
            if ("null".equals(dataArray[i])) {
                nums[i] = null;
            } else {
                nums[i] = Integer.valueOf(dataArray[i]);
            }
        }
        return nums;

    }


    public static void main(String[] args) {
        TreeNode node =
            TreeNodeUtils.createTreeNodeByArray(
                new Integer[] {});

        SolutionNo297 solution = new SolutionNo297();
        String serialize = solution.serialize(node);
        //System.out.println(serialize);
        //
        //
        //Integer[] integers =
        //    solution.convertString2Nums("[1,2,3,null,null,4,5,null,null,null,null]");

        TreeNode treeNode = solution.deserialize(serialize);


        //System.out.println(treeNode.val);
    }
}
