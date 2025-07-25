package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

public class Solution114 {
    public static void main(String[] args) {
//        输入：root = [1,2,5,3,4,null,6]
//        输出：[1,null,2,null,3,null,4,null,5,null,6]

        TreeNode root = TreeNodeTools.buildTree(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        new Solution114().flatten(root);
        System.out.println("root = " + root);
    }

    public void flatten(TreeNode root) {


    }
}
