package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

public class Reverse {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode);

        ListNode reversed = new Reverse().reverse(listNode);
        System.out.println("reversed = " + reversed);
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }
}
