package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution43 {
    public void reorderList(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            current.next = reversed(current.next);
            current = current.next;
        }
    }

    private ListNode reversed(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = preNode;

            preNode = currentNode;
            currentNode = next;
        }

        return preNode;
    }

    public static void main(String[] args) {
//        输入：head = [1,2,3,4,5]
//        输出：[1,5,2,4,3]

        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.buildListNode(nums);
        new Solution43().reorderList(head);
        System.out.println("head = " + head);
    }
}
