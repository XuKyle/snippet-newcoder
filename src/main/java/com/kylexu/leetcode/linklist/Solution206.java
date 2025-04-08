package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution206 {
    public static void main(String[] args) {
//       args 输入：head = [1,2,3,4,5]
//        输出：[5,4,3,2,1]

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("listNode = " + listNode);

        ListNode reverseList = new Solution206().reverseList(listNode);
        System.out.println("reverseList = " + reverseList);
    }

    public ListNode reverseList(ListNode head) {
        // 基准条件：空链表或单节点链表无需反转
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转后续节点（处理head.next开始的子链表）
        ListNode reversed = reverseList(head.next);

        // 将当前节点追加到反转后的子链表尾部（head.next此时已是反转后的尾节点）
        head.next.next = head;

        // 断开原链表的连接（避免形成环形链表）
        head.next = null;

        // 返回新链表的头节点（原链表的尾节点）
        return reversed;
    }

    public ListNode reverseListV2(ListNode head) {
        ListNode temp; // 临时变量用于暂存节点，防止指针丢失
        ListNode current = head; // 当前处理的节点，初始化为头节点
        ListNode pre = null; // 前驱节点，初始化为null（反转后的尾节点next会指向null）

        // 当当前节点存在时持续遍历（直到原链表末尾）
        while (current != null) {
            temp = current.next;    // 保存当前节点的下一个节点（防止反转后无法访问后续节点）
            current.next = pre;     // 关键反转操作：将当前节点的next指向前驱节点
            pre = current;          // 前驱节点移动到当前节点（准备处理下一个节点）
            current = temp;         // 当前节点移动到下一个待处理的节点
        }

        return pre; // 返回新链表的头节点（原链表的尾节点）
    }
}
