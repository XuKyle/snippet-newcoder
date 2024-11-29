package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode preNode = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;

            current.next = preNode;
            preNode = current;
            current = next;
        }
        return preNode;
    }

    public static void main(String[] args) {
//       args 输入：head = [1,2,3,4,5]
//        输出：[5,4,3,2,1]

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode);

        ListNode reverseList = new Solution206().reverseList(listNode);
        System.out.println("reverseList = " + reverseList);
    }
}
