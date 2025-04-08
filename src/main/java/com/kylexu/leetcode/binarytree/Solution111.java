package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
public class Solution111 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.stream(arr).toList());
        int rs = new Solution111().minDepth(treeNode);
        System.out.println("rs = " + rs);
    }

    public int minDepth(TreeNode root) {
        int level = 0;
        if (root == null) {
            return level;
        }

        LinkedList<TreeNode> helper = new LinkedList<>();
        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();
            while (n > 0) {
                TreeNode current = helper.removeFirst();
                if (current.left == null && current.right == null) {
                    return level + 1;
                }
                if (current.left != null) {
                    helper.add(current.left);
                }
                if (current.right != null) {
                    helper.add(current.right);
                }
                n--;
            }
            level++;
        }


        return level;
    }
}
