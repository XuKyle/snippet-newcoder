package com.kylexu.leetcode.company.jd;

import com.kylexu.bean.ListNode;

public class Solution23 {
    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};

//        System.out.println(new Solution23().mergeList(listNode1, listNode2));
        System.out.println(new Solution23().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return new ListNode();
        }
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = mergeList(list, lists[i]);
        }
        return list;
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeList(list1.next, list2);
            return list1;
        }

        list2.next = mergeList(list1, list2.next);
        return list2;
    }
}
