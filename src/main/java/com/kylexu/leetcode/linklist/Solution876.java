package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Solution876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
//        输入：head = [1,2,3,4,5,6]
//        输出：[4,5,6]
//        解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println("listNode = " + listNode);

        ListNode listNode1 = new Solution876().middleNode(listNode);
        System.out.println("listNode1 = " + listNode1);

        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode2);

        ListNode rs = new Solution876().middleNode(listNode2);
        System.out.println("rs = " + rs);
    }
}
