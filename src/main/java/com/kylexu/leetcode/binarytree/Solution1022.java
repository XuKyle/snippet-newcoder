package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1022 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(List.of(1, 0, 1, 0, 1, 0, 1));
//        System.out.println("treeNode = " + treeNode);
        int rs = new Solution1022().sumRootToLeaf(treeNode);
        System.out.println("rs = " + rs);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public int sumRootToLeaf(TreeNode root) {
        int rs = 0;
        dfs(root);

        for (List<Integer> r : result) {
            int t = 0;
            for (Integer i : r) {
                t = t * 2 + i;
            }
            rs += t;
        }

        return rs;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        dfs(root.left);
        dfs(root.right);
        path.removeLast();
    }
}
