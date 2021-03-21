package com.beiwu.zhou.review1;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-21 17:52
 */
public class S206 {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            // 递归出口 如果是null 或者没有下一个 直接返回
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }


    public static void main(String[] args) {
        S206 s206 = new S206();

        ListNode head = LinkedListNodeUtils.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        ListNode reversedList = s206.reverseList1(head);
        LinkedListNodeUtils.printListNode(reversedList);

    }
}
