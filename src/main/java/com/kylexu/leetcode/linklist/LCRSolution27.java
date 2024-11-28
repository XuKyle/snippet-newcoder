package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class LCRSolution27 {
    public static void main(String[] args) {
//        输入: head = [1,2,3,3,2,1]
//        输出: true

        int[] nums = new int[]{1, 2, 3, 3, 2, 1};
        ListNode head = ListNode.buildListNode(nums);
        System.out.println(new LCRSolution27().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }

        while (deque.size() > 1) {
            Integer first = deque.removeFirst();
            Integer last = deque.removeLast();

            if (!first.equals(last)) {
                return false;
            }
        }

        return true;
    }
}
