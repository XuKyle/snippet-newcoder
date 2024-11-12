package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;


public class ReverseBetween {
    ListNode stopReverseNode;

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode);

//        ListNode reversedBefore = new ReverseBetween().reverse(listNode, 4);
//        System.out.println("reversedBefore = " + reversedBefore);

        ListNode reversed = new ReverseBetween().reverseBetween(listNode, 2, 4);
        System.out.println("reversed = " + reversed);
    }

    ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;
    }

    ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            stopReverseNode = head.next;
            return head;
        }

        ListNode rs = reverse(head.next, n - 1);

        head.next.next = head;
        head.next = stopReverseNode;

        return rs;
    }
}
