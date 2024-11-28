package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

import java.util.Arrays;

/**
 * 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。
 * 为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,6,4,1]
 * <p>
 * 输出：[1,4,6,3]
 */
public class LCRSolution123 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 4, 1};
        ListNode node = ListNode.buildListNode(nums);
        System.out.println(Arrays.toString(new LCRSolution123().reverseBookList(node)));
    }

    public int[] reverseBookList(ListNode head) {
        int cnt = 0;
        ListNode node = head;
        while (node != null) {
            cnt++;
            node = node.next;
        }

        int[] rs = new int[cnt];
        ListNode current = head;

        for (int i = rs.length - 1; i >= 0; i--) {
            rs[i] = current.val;
            current = current.next;
        }

        return rs;
    }
}
