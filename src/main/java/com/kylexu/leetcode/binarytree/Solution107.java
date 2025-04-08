package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.*;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 */
public class Solution107 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.stream(arr).toList());
        List<List<Integer>> rs = new Solution107().levelOrderBottom(treeNode);
        System.out.println("rs = " + rs);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<TreeNode> helper = new LinkedList<>();

        if (root == null) {
            return rs;
        }
        helper.add(root);

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
            rs.add(inner);
        }

        Collections.reverse(rs);
        return rs;
    }
}
