package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

/**
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 */
public class Solution445 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{5});
        ListNode l2 = ListNode.buildListNode(new int[]{5});

        ListNode listNode = new Solution445().addTwoNumbers(l1, l2);
        System.out.println("listNode = " + listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);

        ListNode dumy = new ListNode();
        ListNode head = new ListNode();
        dumy.next = head;
        int add = 0;

        while (reverseL1 != null || reverseL2 != null) {
            int temp = 0;
            if (reverseL1 != null) {
                temp += reverseL1.val;
                reverseL1 = reverseL1.next;
            }

            if (reverseL2 != null) {
                temp += reverseL2.val;
                reverseL2 = reverseL2.next;
            }

            head.val = (temp + add) % 10;
            add = (temp + add) / 10;
            head.next = new ListNode();
            head = head.next;
        }
        if (add != 0) {
            head.val = add;
            return reverse(dumy.next);
        }

        return reverse(dumy.next).next;
    }

    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode reverse = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return reverse;
    }
}
