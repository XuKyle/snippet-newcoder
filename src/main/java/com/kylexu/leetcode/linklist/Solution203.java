package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class Solution203 {
    public static void main(String[] args) {
//        输入：head = [1,2,6,3,4,5,6], val = 6
//        输出：[1,2,3,4,5]
//        示例 2：
//
//        输入：head = [], val = 1
//        输出：[]
//        示例 3：
//
//        输入：head = [7,7,7,7], val = 7
//        输出：[]

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = ListNode.buildListNode(nums);

        System.out.println(new Solution203().removeElements(head, 6));

    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
