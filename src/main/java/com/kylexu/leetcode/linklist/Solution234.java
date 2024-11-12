package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 */
public class Solution234 {
//    输入：head = [1,2,2,1]
//    输出：true

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode slow) {
        if (slow == null) {
            return null;
        }
        ListNode current = slow;
        ListNode preNode = null;
        while (current != null) {
            ListNode node = current.next;
            current.next = preNode;
            preNode = current;
            current = node;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println("listNode = " + listNode);
        Solution234 solution234 = new Solution234();
        System.out.println(solution234.isPalindrome(listNode));
    }
}
