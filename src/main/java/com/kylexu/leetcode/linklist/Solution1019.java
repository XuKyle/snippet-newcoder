package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

import java.util.Arrays;

public class Solution1019 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{2, 7, 4, 3, 5});
        int[] rs = new Solution1019().nextLargerNodes(listNode);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] nextLargerNodes(ListNode head) {


        return new int[]{};
    }
}
