package com.kylexu.leetcode.linklist;

import com.kylexu.bean.ListNode;

public class SolutionLCR23 {
    public static void main(String[] args) {
//        输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3


        ListNode listNodeAB5 = new ListNode(5);
        ListNode listNodeAB4 = new ListNode(4, listNodeAB5);
        ListNode listNodeAB3 = new ListNode(8, listNodeAB4);
        ListNode listNodeA2 = new ListNode(1, listNodeAB3);
        ListNode listNodeA1 = new ListNode(4, listNodeA2);

        ListNode listNodeB3 = new ListNode(1, listNodeAB3);
        ListNode listNodeB2 = new ListNode(0, listNodeB3);
        ListNode listNodeB1 = new ListNode(5, listNodeB2);


        System.out.println(new SolutionLCR23().getIntersectionNode(listNodeA1, listNodeB1));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        ListNode dummyA = new ListNode(-1, headA);
//        ListNode dummyB = new ListNode(-1, headB);
//
//        int stepA = 0;
//        int stepB = 0;
//
//        while (headA != null) {
//            stepA++;
//            headA = headA.next;
//        }
//
//        while (headB != null) {
//            stepB++;
//            headB = headB.next;
//        }
//
//
//        int n = Math.abs(stepA - stepB);
//        headA = dummyA.next;
//        headB = dummyB.next;
//        while (n > 0) {
//            if (stepA > stepB) {
//                headA = headA.next;
//            } else {
//                headB = headB.next;
//            }
//            n--;
//        }
//
//        while (headA != null && headB != null) {
//            if (headA == headB) {
//                return headA;
//            }
//            headA = headA.next;
//            headB = headB.next;
//        }
//
//        return null;
//    }
}
