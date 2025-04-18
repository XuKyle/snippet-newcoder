package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class Solution103 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeTools.buildTree(nums);
        List<List<Integer>> rs = new Solution103().zigzagLevelOrder(treeNode);
        System.out.println("rs = " + rs);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }
        LinkedList<TreeNode> helper = new LinkedList<>();
        helper.add(root);

        boolean reversed = false;
        while (!helper.isEmpty()) {
            int n = helper.size();
            List<Integer> inner = new ArrayList<>();
            while (n > 0) {
                TreeNode treeNode = helper.removeFirst();
                inner.add(treeNode.val);
                if (treeNode.left != null) {
                    helper.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                }
                n--;
            }
            if (reversed) {
                Collections.reverse(inner);
                rs.add(inner);
            } else {
                rs.add(inner);
            }
            reversed = !reversed;
        }

        return rs;
    }
}
