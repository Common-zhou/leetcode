package com.beiwu.zhou;

/**
 * @author zhoubing
 * @date 2021-03-20 11:43
 */
public class LinkedListNodeUtils {
    public static void printListNode(ListNode listNode){
        if (listNode == null){
            System.out.println("当前链表为空");
        }
        StringBuilder sb = new StringBuilder("[");
        while (listNode != null){
            sb.append(listNode.val);
            listNode = listNode.next;
            if (listNode != null){
                sb.append(",");
            }
        }
        System.out.println(sb.append("]").toString());
    }

    public static ListNode createLinkedList(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }

        ListNode head = new ListNode(nums[0], null);
        ListNode cur = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            cur.next = listNode;
            cur = listNode;
        }
        return head;
    }
}
