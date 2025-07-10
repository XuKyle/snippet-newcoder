package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

public class Solution2379 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.asList(7, 4, 3, null, null, 6, 19));
        TreeNode targetCopy = new Solution2379().getTargetCopy(treeNode, treeNode, treeNode.right);
        int target = 3;
        System.out.println("targetCopy = " + targetCopy);
    }

    TreeNode t;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned, target);
        return t;
    }


    private void dfs(TreeNode cloned, TreeNode target) {
        if (cloned.val == target.val) {
            t = cloned;
            return;
        }

        if (cloned.left != null) {
            dfs(cloned.left, target);
        }
        if (cloned.right != null) {
            dfs(cloned.right, target);
        }
    }
}
