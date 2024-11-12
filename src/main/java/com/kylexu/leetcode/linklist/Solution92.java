package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverse(ListNode head, int firstN) {
        if (firstN == 1) {
            stopReverseMarkNode = head.next;
            return head;
        }

        ListNode reversed = reverse(head.next, firstN - 1);
        head.next.next = head;
        head.next = stopReverseMarkNode;
        return reversed;
    }

    ListNode stopReverseMarkNode;

    public static void main(String[] args) {
//        head = [1,2,3,4,5], left = 2, right = 4
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode);

//        ListNode reverse = new Solution92().reverse(listNode, 2);
//        System.out.println("reverse = " + reverse);
//
        ListNode reverseBetween = new Solution92().reverseBetween(listNode, 2, 4);
        System.out.println("reverseBetween = " + reverseBetween);
    }
}
