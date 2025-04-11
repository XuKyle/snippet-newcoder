package com.kylexu.leetcode.tree;

import com.kylexu.bean.NTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {
    public static void main(String[] args) {
        NTreeNode nTreeNode1 = new NTreeNode(1, new ArrayList<>());
        NTreeNode nTreeNode3 = new NTreeNode(3, new ArrayList<>());
        NTreeNode nTreeNode2 = new NTreeNode(2);
        NTreeNode nTreeNode4 = new NTreeNode(4);
        NTreeNode nTreeNode5 = new NTreeNode(5);
        NTreeNode nTreeNode6 = new NTreeNode(6);

        nTreeNode3.children.addAll(List.of(nTreeNode5, nTreeNode6));
        nTreeNode1.children.addAll(List.of(nTreeNode3, nTreeNode2, nTreeNode4));

        var rs = new Solution589().preorder(nTreeNode1);
        System.out.println("rs = " + rs);
    }

    public List<Integer> preorder(NTreeNode root) {
        List<Integer> rs = new ArrayList<>();
        dfs(root, rs);
        return rs;
    }

    private void dfs(NTreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }

        rs.add(root.val);
        if (root.children != null) {
            for (NTreeNode child : root.children) {
                dfs(child, rs);
            }
        }
    }
}
