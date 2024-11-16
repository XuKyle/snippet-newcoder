package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution25 {
    public static void main(String[] args) {
//        输入：head = [1,2,3,4,5], k = 2
//        输出：[2,1,4,3,5]

//        输入：head = [1,2,3,4,5], k = 3
//        输出：[3,2,1,4,5]

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode reverseKGroup = new Solution25().reverseKGroup(listNode, 2);
//        System.out.println("reverseKGroup = " + reverseKGroup);

        System.out.println(new Solution25().reverse(listNode));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reverse(start);

            start.next = next;

            pre = start;
            end = start;
        }

        return dummy.next;
    }

//    private ListNode reverse(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode reverse = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return reverse;
//    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }

        return pre;
    }
}
