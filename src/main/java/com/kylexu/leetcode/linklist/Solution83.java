package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class Solution83 {
    public static void main(String[] args) {
//       args head = [1,1,2]

        ListNode listNode3 = new ListNode(2);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        System.out.println("listNode1 = " + listNode1);

        ListNode listNode = new Solution83().deleteDuplicates(listNode1);
        System.out.println("listNode = " + listNode);

        System.out.println(new Solution83().deleteDuplicatesRecursion(listNode1));

    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            return head.next;
        }
        return head;
    }

}
