package leetcode.linklist;

import com.kylexu.bean.ListNode;

public class SolutionInterview0207 {
    public static void main(String[] args) {
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode2 = new ListNode(2, listNode4);
//
//        ListNode listNode1 = new ListNode(1, listNode2);
//        ListNode listNode9 = new ListNode(9, listNode1);
//        ListNode headA = new ListNode(0, listNode9);
//
//        ListNode headB = new ListNode(3, listNode2);

        ListNode headA = ListNode.buildListNode(new int[]{1, 2, 3});
        ListNode headB = ListNode.buildListNode(new int[]{1, 2, 3, 4});

        ListNode rs = new SolutionInterview0207().getIntersectionNode(headA, headB);
        System.out.println("rs = " + rs);
    }

    //   输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }

            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }

        return p;
    }
}
