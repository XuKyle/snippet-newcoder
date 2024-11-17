package com.kylexu.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        Set<ListNode> listNodeSet = new HashSet<>();

        ArrayList<Integer> rs = new ArrayList<>();

        ListNode node = this;
        while (node != null) {
            if (listNodeSet.contains(node)) {
                // 防止出现环形链表。
                break;
            }
            listNodeSet.add(node);
            rs.add(node.val);
            node = node.next;
        }

        return "ListNode[" +
                rs.stream().map(String::valueOf).collect(Collectors.joining(","))
                + "]";
    }
}