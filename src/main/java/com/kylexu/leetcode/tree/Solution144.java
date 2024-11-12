package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    public static void main(String[] args) {
//        二叉树的前序遍历
        //输入：root = [1,null,2,3]
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(new Solution144().preorderTraversal(treeNode));
        System.out.println(new Solution144().preorderTraversalWithLoop(treeNode));

//        输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
        TreeNode treeNode1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(6), new TreeNode(7))),
                new TreeNode(3,
                        null,
                        new TreeNode(8,
                                new TreeNode(9),
                                null)
                )
        );

        System.out.println(new Solution144().preorderTraversal(treeNode1));
        System.out.println(new Solution144().preorderTraversalWithLoop(treeNode1));
    }

    public List<Integer> preorderTraversalWithLoop(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                rs.add(current.val);
                stack.add(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }

        return rs;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        travel(root, rs);
        return rs;
    }

    private void travel(TreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }
        rs.add(root.val);
        travel(root.left, rs);
        travel(root.right, rs);
    }
}
