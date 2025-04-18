package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.*;

/**
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 */
public class Solution501 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(new Integer[]{1, null, 2, 2});
        int[] rs = new Solution501().findMode(treeNode);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        counter(root, counter);

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }

        List<Integer> rs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == max) {
                rs.add(entry.getKey());
            }
        }

        return rs.stream().mapToInt(Integer::intValue).toArray();
    }

    private void counter(TreeNode root, Map<Integer, Integer> counter) {
        if (root == null) {
            return;
        }

        counter.merge(root.val, 1, Integer::sum);
        if (root.left != null) {
            counter(root.left, counter);
        }
        if (root.right != null) {
            counter(root.right, counter);
        }
    }
}
