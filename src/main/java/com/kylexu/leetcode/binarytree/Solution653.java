package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.*;

public class Solution653 {
    public static void main(String[] args) {
//        输入: root = [5,3,6,2,4,null,7], k = 28
//        输出: true
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.asList(1));
        int k = 2;
        boolean target = new Solution653().findTarget(treeNode, k);
        System.out.println("target = " + target);
    }

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> values = new HashMap<>();
        dfs(root, values);

        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            int i = k - entry.getKey();
            if (i == entry.getKey()) {
                if (entry.getValue() >= 2) {
                    return true;
                }
            } else if (values.containsKey(i)) {
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> values) {
        if (root == null) {
            return;
        }
        values.merge(root.val, 1, Integer::sum);
        dfs(root.left, values);
        dfs(root.right, values);
    }
}
