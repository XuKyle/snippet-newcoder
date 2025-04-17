package com.kylexu.leetcode.tree;

import com.kylexu.bean.NTreeNode;
import com.kylexu.bean.NTreeNodeTools;

import java.util.ArrayList;
import java.util.List;

public class Solution590 {
    public static void main(String[] args) {
        NTreeNode nTreeNode = NTreeNodeTools.buildTree(new Integer[]{1, null, 3, 2, 4, null, 5, 6});
        List<Integer> postorder = new Solution590().postorder(nTreeNode);
        System.out.println("postorder = " + postorder);
    }

    public List<Integer> postorder(NTreeNode root) {
        List<Integer> rs = new ArrayList<>();
        dfs(root, rs);
        return rs;
    }

    private void dfs(NTreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }

        if (root.children != null && !root.children.isEmpty()) {
            for (NTreeNode child : root.children) {
                dfs(child, rs);
            }
        }
        rs.add(root.val);
    }
}
