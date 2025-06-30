package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;
import java.util.List;

public class Solution563 {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(4, 2, 9, 3, 5, null, 7);
        TreeNode treeNode = TreeNodeTools.buildTree(data);
        int tilt = new Solution563().findTilt(treeNode);
        System.out.println("tilt = " + tilt);
    }

    public int findTilt(TreeNode root) {

        return 0;
    }


    private int leftSum(TreeNode root) {
        return 1;
    }


}
