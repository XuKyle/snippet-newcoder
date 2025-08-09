package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

public class Solution572 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeTools.buildTree(Arrays.asList(3, 4, 5, 1, 2, null, null, null, null, 0));
        TreeNode subRoot = TreeNodeTools.buildTree(Arrays.asList(4, 1, 2));
        boolean subtree = new Solution572().isSubtree(root, subRoot);
        System.out.println("subtree = " + subtree);
    }



    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }



//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        TreeNode head = findHead(root, subRoot.val);
//        System.out.println("head = " + head);
//        System.out.println("subRoot = " + subRoot.val);
//        return isIdentical(head, subRoot);
//    }
//    private boolean isIdentical(TreeNode head, TreeNode subRoot) {
//        if (head == null && subRoot == null) {
//            return true;
//        } else if (head == null) {
//            return false;
//        } else if (subRoot == null) {
//            return false;
//        }
//
//        if (head.val == subRoot.val) {
//            return isIdentical(head.left, subRoot.left) && isIdentical(head.right, subRoot.right);
//        }
//
//        return false;
//    }
//
//    public TreeNode findHead(TreeNode root, int val) {
//        if (root.val == val) {
//            return root;
//        }
//
//        if (root.left != null) {
//            return findHead(root.left, val);
//        }
//        if (root.right != null) {
//            return findHead(root.right, val);
//        }
//
//        return root;
//    }
}
