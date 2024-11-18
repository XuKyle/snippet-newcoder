package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

public class ReverseFirstN {
    ListNode stopReverseNode;

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode);


        ListNode reversed = new ReverseFirstN().reverseN(listNode, 3);
        System.out.println("reversed = " + reversed);
    }


    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            stopReverseNode = head.next;
            return head;
        }

        ListNode reversed = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = stopReverseNode;

        return reversed;
    }


//
//    ListNode reverseN(ListNode head, int n) {
//        if (n == 1) {
//            stopReverseNode = head.next;
//            return head;
//        }
//
//        ListNode tail = reverseN(head.next, n - 1);
//        head.next.next = head;
//        head.next = stopReverseNode;
//        return tail;
//    }
}
