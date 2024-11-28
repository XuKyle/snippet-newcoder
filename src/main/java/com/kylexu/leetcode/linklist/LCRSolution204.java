package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

public class LCRSolution204 {
    public static void main(String[] args) {
//        输入：head = [1,2,3,4,5]
//        输出：[5,4,3,2,1]

        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode node = ListNode.buildListNode(nums);
        System.out.println(new LCRSolution204().reverseList(node));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }
}
