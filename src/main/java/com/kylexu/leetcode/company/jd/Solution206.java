package com.kylexu.leetcode.company.jd;

import com.kylexu.bean.ListNode;

public class Solution206 {
    public static void main(String[] args) {
//        输入：head = [1,2,3,4,5]
//        输出：[5,4,3,2,1]

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new Solution206().reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {
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

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode last = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return last;
//    }
}
