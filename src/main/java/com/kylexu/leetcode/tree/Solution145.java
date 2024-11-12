package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    public static void main(String[] args) {
//        二叉树的前序遍历
        //输入：root = [1,null,2,3]
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(new Solution145().postorderTraversal(treeNode));
//        System.out.println(new Solution145().preorderTraversalWithLoop(treeNode));

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

        System.out.println(new Solution145().postorderTraversal(treeNode1));
//        System.out.println(new Solution145().preorderTraversalWithLoop(treeNode1));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        travel(root, rs);
        return rs;
    }

    public void travel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        travel(root.left, list);
        travel(root.right, list);
        list.add(root.val);
    }
}
