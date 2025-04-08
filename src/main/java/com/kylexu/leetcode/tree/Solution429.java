package com.kylexu.leetcode.tree;

import com.kylexu.bean.NTreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class Solution429 {
    public static void main(String[] args) {

        NTreeNode node1 = new NTreeNode(1, new ArrayList<>());
        NTreeNode node2 = new NTreeNode(2);
        NTreeNode node3 = new NTreeNode(3, new ArrayList<>());
        NTreeNode node4 = new NTreeNode(4);
        NTreeNode node5 = new NTreeNode(5);
        NTreeNode node6 = new NTreeNode(6);
        node3.children.addAll(List.of(node5, node6));
        node1.children.addAll(List.of(node3, node2, node4));

        List<List<Integer>> listList = new Solution429().levelOrder(node1);
        System.out.println("listList = " + listList);
    }

    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<NTreeNode> helper = new LinkedList<>();

        if (root == null) {
            return rs;
        }
        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();
            List<Integer> inner = new ArrayList<>();

            while (n > 0) {
                NTreeNode current = helper.removeFirst();
                inner.add(current.val);

                if (current.children != null) {
                    helper.addAll(current.children);
                }

                n--;
            }
            rs.add(inner);
        }

        return rs;
    }
}
