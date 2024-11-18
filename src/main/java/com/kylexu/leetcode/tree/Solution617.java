package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

public class Solution617 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(new Solution617().mergeTrees(root1, root2));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);
        return treeNode;
    }


//    输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//    输出：[3,4,5,5,4,null,7]
//    示例 2：
//
//    输入：root1 = [1], root2 = [1,2]
//    输出：[2,2]
}
