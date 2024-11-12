package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class Solution21 {
    public static void main(String[] args) {
        ListNode node13 = new ListNode(4);
        ListNode node12 = new ListNode(2, node13);
        ListNode node1 = new ListNode(1, node12);

        ListNode node23 = new ListNode(4);
        ListNode node22 = new ListNode(3, node23);
        ListNode node2 = new ListNode(1, node22);

        ListNode listNode = new Solution21().mergeTwoListsRecursion(node1, node2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode start = new ListNode();
        ListNode current = start;
        while (list1 != null && list2 != null) {
            if (list2.val <= list1.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        }
        if (list2 == null) {
            current.next = list1;
        }
        return start.next;
    }


    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list2.val <= list1.val) {
            list2.next = mergeTwoListsRecursion(list1, list2.next);
            return list2;
        }

        list1.next = mergeTwoListsRecursion(list1.next, list2);
        return list1;
    }
}

