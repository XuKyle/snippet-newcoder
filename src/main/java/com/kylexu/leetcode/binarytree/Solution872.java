package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution872 {
    public static void main(String[] args) {
//        输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        TreeNode root1 = TreeNodeTools.buildTree(Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4));
        TreeNode root2 = TreeNodeTools.buildTree(Arrays.asList(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8));

        boolean rs = new Solution872().leafSimilar(root1, root2);
        System.out.println("rs = " + rs);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = leaf(root1);
        List<Integer> leaf2 = leaf(root2);

        if (leaf1.size() != leaf2.size()) {
            return false;
        }

        for (int i = 0; i < leaf1.size(); i++) {
            if (Integer.compare(leaf1.get(i), leaf2.get(i)) != 0) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> leaf(TreeNode treeNode) {
        List<Integer> rs = new ArrayList<>();
        helper(treeNode, rs);
        return rs;
    }

    private void helper(TreeNode treeNode, List<Integer> rs) {
        if (treeNode.left == null && treeNode.right == null) {
            rs.add(treeNode.val);
            return;
        }

        if (treeNode.left != null) {
            helper(treeNode.left, rs);
        }

        if (treeNode.right != null) {
            helper(treeNode.right, rs);
        }
    }
}
