package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

import java.util.*;

public class Solution94 {
    public static void main(String[] args) {
//        二叉树的中序遍历
        //输入：root = [1,null,2,3]
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(new Solution94().inorderTraversal(treeNode));
        System.out.println(new Solution94().inorderTraversalWithLoop(treeNode));
    }

    public List<Integer> inorderTraversalWithLoop(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                rs.add(current.val);
                current = current.right;
            }
        }

        return rs;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        travel(root, rs);
        return rs;
    }

    private void travel(TreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }
        travel(root.left, rs);
        rs.add(root.val);
        travel(root.right, rs);
    }
}
