package com.beiwu.zhou.no0_100;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-20 12:03
 */
public class SolutionNo24 {

    public ListNode swapPairs1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        while (prev != null && cur != null) {
            ListNode nextResolve = cur.next;
            prev.next = nextResolve;
            cur.next = prev;
            if (nextResolve == null || nextResolve.next == null) {
                cur = null;
            } else {
                cur = nextResolve.next;
            }
            prev = nextResolve;
        }


        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode node = swapPairs(newHead.next);

        newHead.next = head;
        head.next = node;
        return newHead;

    }

        public static void main(String[] args) {
        ListNode head = LinkedListNodeUtils.createLinkedList(new int[]{1, 2, 3, 4, 5});
        LinkedListNodeUtils.printListNode(head);

        ListNode node = new SolutionNo24().swapPairs(head);

        LinkedListNodeUtils.printListNode(node);
    }
}
