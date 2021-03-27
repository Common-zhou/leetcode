package com.beiwu.zhou.no100_200;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-20 15:18
 */
public class SolutionNo141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && fast.next.next != null) {
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListNodeUtils.createLinkedList(new int[]{3, 2, 0, -4});
        //ListNode cur = list;
        //while (cur.next != null){
        //    cur = cur.next;
        //}
        //cur.next = list.next;

        System.out.println(new SolutionNo141().hasCycle(list));

    }
}
