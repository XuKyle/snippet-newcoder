package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

import java.util.Arrays;

public class Solution1290V1 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1, 0, 1});
        int decimalValue = new Solution1290V1().getDecimalValue(head);
        System.out.println("decimalValue = " + decimalValue);
    }

    public int getDecimalValue(ListNode head) {
        int rs = 0;

        while (head != null) {
            rs = rs * 2 + head.val;
            head = head.next;
        }
        
        return rs;
    }
}
