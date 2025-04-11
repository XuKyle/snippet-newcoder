package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.List;

public class Solution226 {
    public static void main(String[] args) {
        //[4,2,7,1,3,6,9]
        TreeNode treeNode = TreeNodeTools.buildTree(List.of(4, 2, 7, 1, 3, 6, 9));
        System.out.println(new Solution226().invertTree(treeNode));
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        var left = invertTree(root.right);
        var right = invertTree(root.left);

        root.left = left;
        root.right = right;

        return root;
    }
}
