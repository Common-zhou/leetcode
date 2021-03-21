package com.beiwu.zhou.review1;

import com.beiwu.zhou.LinkedListNodeUtils;
import com.beiwu.zhou.ListNode;

/**
 * @author zhoubing
 * @date 2021-03-22 00:09
 */
public class S141 {
    /**
     * 快慢指针方法
     * 时间复杂度
     * 空间复杂度
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        ListNode list = LinkedListNodeUtils.createLinkedList(new int[]{3, 2, 0, -4});
        //ListNode cur = list;
        //while (cur.next != null) {
        //    cur = cur.next;
        //}
        //cur.next = list.next;

        System.out.println(new S141().hasCycle(list));
    }
}
