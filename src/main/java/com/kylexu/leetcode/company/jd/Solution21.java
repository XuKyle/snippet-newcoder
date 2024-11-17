package com.kylexu.leetcode.company.jd;

import com.kylexu.bean.ListNode;

public class Solution21 {
    public static void main(String[] args) {
//        输入：l1 = [1,2,4], l2 = [1,3,4]
//        输出：[1,1,2,3,4,4]

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

//        System.out.println(new Solution21().mergeTwoLists(list1, list2));
        System.out.println(new Solution21().mergeTwoListsRecursive(list1, list2));
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list2.val < list1.val) {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }

        list1.next = mergeTwoListsRecursive(list1.next, list2);
        return list1;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }
}
