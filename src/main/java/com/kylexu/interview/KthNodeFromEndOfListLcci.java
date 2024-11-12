package com.kylexu.interview;

import com.kylexu.bean.ListNode;

public class KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
//        1->2->3->4->5 和 k = 2
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode);

        System.out.println(new KthNodeFromEndOfListLcci().kthToLast(listNode, 2));
    }

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
