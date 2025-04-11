package com.kylexu.leetcode.tree;

import com.kylexu.bean.NTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution559 {
    public static void main(String[] args) {
//[1,null,3,2,4,null,5,6]

        NTreeNode nTreeNode1 = new NTreeNode(1, new ArrayList<>());
        NTreeNode nTreeNode3 = new NTreeNode(3, new ArrayList<>());
        NTreeNode nTreeNode2 = new NTreeNode(2);
        NTreeNode nTreeNode4 = new NTreeNode(4);
        NTreeNode nTreeNode5 = new NTreeNode(5);
        NTreeNode nTreeNode6 = new NTreeNode(6);

        nTreeNode3.children.addAll(List.of(nTreeNode5, nTreeNode6));
        nTreeNode1.children.addAll(List.of(nTreeNode3, nTreeNode2, nTreeNode4));

        int rs = new Solution559().maxDepth(nTreeNode1);
        System.out.println("rs = " + rs);
    }

    public int maxDepth(NTreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }

        int rs = 0;
        for (NTreeNode child : root.children) {
            rs = Math.max(maxDepth(child), rs);
        }
        return rs + 1;
    }
}
