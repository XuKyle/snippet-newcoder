package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution897 {
    public static void main(String[] args) {
//        root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9));
        TreeNode rs = new Solution897().increasingBST(treeNode);
        System.out.println("rs = " + rs);
    }

    TreeNode node = new TreeNode();
    boolean firstNode = true;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = node;
        dfs(root);
        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (firstNode) {
            firstNode = false;
            node.val = root.val;
        } else {
            node.right = new TreeNode(root.val);
            node = node.right;
        }
        dfs(root.right);
    }
}
