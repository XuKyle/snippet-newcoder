package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * LCR 140. 训练计划 II
 * 简单
 * <p>
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [2,4,7,8], cnt = 1
 * 输出：8
 */
public class LCRSolution140 {
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(7, new ListNode(8))));
        ListNode listNode = new ListNode(1, new ListNode(2));
        ListNode rs = new LCRSolution140().trainingPlan(listNode, 2);
        System.out.println("rs = " + rs);
    }

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
            if (fast == null) {
                return slow;
            }
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (fast == null) {
            return slow;
        }
        return slow.next;
    }
}
