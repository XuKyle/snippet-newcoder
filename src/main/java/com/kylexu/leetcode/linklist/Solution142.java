package com.kylexu.leetcode.linklist;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 */

import com.kylexu.bean.ListNode;

/**
 * 双指针法是定义一个快指针，一个慢指针；
 * 让满指针每次走一步，快指针一次走两步，他们一定会在环内相遇； 相遇后确定入口位置；
 * 首先设快指针走的路程为f慢为s
 * F=s+nb b是走一圈环形链表所需的步数；n是圈数；
 * F=2s 因为f走2步，s走一步； 得出：s=nb；
 * F=2nb；
 * 咱们脱离这个结果思考，进入环形链表入口所需的步数为多少，
 * 设到环状入口处的距离为a；那么进入入口所需的步数k=a+nb（n=0，1，2.。。。）；
 * 再看上面得出的公式，s=nb，s已经走了nb了，再走a步就能到入口了，
 * 我们把f重新放置在链表头节点处，两个指针一起走，走了a步，那么f现在走了a步，是上面那个公式（a+nb）n等于0的情况，此时f在入口，而s=a+nb所以s也在洞口，所以此时两个指针相遇，返回指针对应的值即可；
 */
public class Solution142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }

        return null;
    }
}
