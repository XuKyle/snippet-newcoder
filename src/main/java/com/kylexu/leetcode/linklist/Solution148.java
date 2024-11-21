package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */

public class Solution148 {
    public static void main(String[] args) {
//        输入：head = [-1,5,3,4,0]
//        输出：[-1,0,3,4,5]
//        new ListNode()
        int[] nums = new int[]{-1, 5, 3, 4, 0};
        ListNode node = ListNode.buildListNode(nums);

        System.out.println(new Solution148().sortList(node));
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode sortedList1 = sortList(head, mid);
        ListNode sortedList2 = sortList(mid, fast);

        return merge(sortedList1, sortedList2);
    }

    private ListNode merge(ListNode sortedList1, ListNode sortedList2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (sortedList1 != null && sortedList2 != null) {
            if (sortedList1.val < sortedList2.val) {
                current.next = sortedList1;
                sortedList1 = sortedList1.next;
            } else {
                current.next = sortedList2;
                sortedList2 = sortedList2.next;
            }
            current = current.next;
        }

        if (sortedList1 != null) {
            current.next = sortedList1;
        }

        if (sortedList2 != null) {
            current.next = sortedList2;
        }

        return dummy.next;
    }
}
