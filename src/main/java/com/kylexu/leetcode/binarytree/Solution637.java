package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * 示例 2:
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 */
public class Solution637 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.stream(arr).toList());
        List<Double> rs = new Solution637().averageOfLevels(treeNode);
        System.out.println("rs = " + rs);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> rs = new ArrayList<>();
        LinkedList<TreeNode> helper = new LinkedList<>();

        if (root == null) {
            return rs;
        }
        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();
            long sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode treeNode = helper.removeFirst();
                sum += treeNode.val;

                if (treeNode.left != null) {
                    helper.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                }
            }
            rs.add(sum * 1.0 / n);
        }

        return rs;
    }
}
