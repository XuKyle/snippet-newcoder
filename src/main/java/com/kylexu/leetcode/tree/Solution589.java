package com.kylexu.leetcode.tree;

import com.kylexu.bean.NTreeNode;
import com.kylexu.bean.NTreeNodeTools;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {
    public static void main(String[] args) {
        NTreeNode root = NTreeNodeTools.buildTree(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});

        //                [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
        // [1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10]
        var rs = new Solution589().preorder(root);
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
