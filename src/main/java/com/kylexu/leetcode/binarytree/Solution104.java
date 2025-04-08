package com.kylexu.leetcode.binarytree;


import com.kylexu.bean.TreeNode;

import java.util.LinkedList;

public class Solution104 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new Solution104().maxDepth(treeNode));
    }

//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
//    }

    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> helper = new LinkedList<>();
        int level = 0;
        if (root == null) {
            return level;
        }

        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();
            while (n > 0) {
                TreeNode treeNode = helper.removeFirst();
                if (treeNode.left != null) {
                    helper.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                }
                n--;
            }
            level++;
        }

        return level;
    }
}
