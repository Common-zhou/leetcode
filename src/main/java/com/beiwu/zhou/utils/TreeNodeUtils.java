package com.beiwu.zhou.utils;

import com.beiwu.zhou.Node;
import com.beiwu.zhou.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubing
 * @date 2021-03-26 15:53
 */
public class TreeNodeUtils {
    public static Node createByArray(Integer[] nums) {
        //[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        // 1-2 是标识第一层的
        // 3-null 是标识第二个的
        Node head = new Node(nums[0]);


        Deque<Node> deque = new LinkedList<>();
        deque.addLast(head);

        int i = 2;
        while (i < nums.length) {
            Node cur = deque.removeFirst();

            // 从第二个开始
            List<Node> children = new ArrayList<>();
            while (i < nums.length && nums[i] != null) {
                // 如果不为null  代表它是一个节点
                Node tmp = new Node(nums[i]);
                children.add(tmp);
                deque.addLast(tmp);
                i++;
            }
            i++;
            cur.children = children;
        }

        return head;

    }

    public static TreeNode createTreeNodeByArray(Integer[] nums) {

        if (nums == null || nums.length == 0){
            return null;
        }

        // [1,2,3,null,null,4,5]
        TreeNode node = new TreeNode(nums[0]);

        Deque<TreeNode> queue = new LinkedList<>();

        queue.addLast(node);

        int i = 0;
        while (i < nums.length && !queue.isEmpty()) {
            TreeNode curNode = queue.removeFirst();

            if ((i * 2 + 1) >= nums.length) {
                break;
            }
            Integer leftNum = nums[i * 2 + 1];
            Integer rightNum = nums[i * 2 + 2];
            if (leftNum != null) {
                curNode.left = new TreeNode(leftNum);
                queue.addLast(curNode.left);
            }
            if (rightNum != null) {
                curNode.right = new TreeNode(rightNum);
                queue.addLast(curNode.right);
            }
            i++;
        }
        return node;
    }


    public static void main(String[] args) {
        Node node = createByArray(
            new Integer[] {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null,
                11, null, 12, null, 13, null, null, 14});

        System.out.println(node.val);


        TreeNode treeNode = createTreeNodeByArray(new Integer[] {1, 2, 3, null, null, 4, 5});
        System.out.println(treeNode);
    }
}
