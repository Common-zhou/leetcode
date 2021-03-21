package com.beiwu.zhou.exercise;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-20 22:38
 */
public class ReverseAll {
    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            //不足俩元素 直接返回
            return head;
        }

        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }

        return head;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            //不足俩元素 直接返回
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListNodeUtils.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        LinkedListNodeUtils.printListNode(head);
        ListNode reverse = reverse(head);
        LinkedListNodeUtils.printListNode(reverse);
    }
}
