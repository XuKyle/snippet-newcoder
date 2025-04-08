package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 */
public class Solution515 {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 5, 3, null, 9};
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.stream(arr).toList());
        List<Integer> list = new Solution515().largestValues(treeNode);
        System.out.println("list = " + list);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        LinkedList<TreeNode> helper = new LinkedList();

        if (root == null) {
            return rs;
        }
        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();
            int max = Integer.MIN_VALUE;
            while (n > 0) {
                TreeNode current = helper.removeFirst();
                max = Math.max(current.val, max);
                if (current.left != null) {
                    helper.add(current.left);
                }
                if (current.right != null) {
                    helper.add(current.right);
                }

                n--;
            }
            rs.add(max);
        }

        return rs;
    }
}
