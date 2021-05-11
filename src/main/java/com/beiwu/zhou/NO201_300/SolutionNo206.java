package com.beiwu.zhou.NO201_300;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author zhoubing
 * @date 2021-03-20 11:27
 */
public class SolutionNo206 {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;

        head.next = null;

        while (cur != null) {
            ListNode curNext = cur.next;
            // 当有值 一直继续
            cur.next = head;
            head = cur;
            cur = curNext;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListNodeUtils.createLinkedList(new int[]{1, 2, 3, 4, 5});

        LinkedListNodeUtils.printListNode(head);

        ListNode node = new SolutionNo206().reverseList(head);

        LinkedListNodeUtils.printListNode(node);
    }
}
