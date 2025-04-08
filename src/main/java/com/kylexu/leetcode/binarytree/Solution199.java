package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,null,5,null,4]
 * 输出：[1,3,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3,4,null,null,null,5]
 * 输出：[1,3,4,5]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,null,3]
 * 输出：[1,3]
 */
public class Solution199 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, 5, null, 4};
        TreeNode root = TreeNodeTools.buildTree(Arrays.stream(arr).toList());
        List<Integer> rs = new Solution199().rightSideView(root);
        System.out.println("rs = " + rs);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        List<List<Integer>> memo = new ArrayList<>();

        LinkedList<TreeNode> helper = new LinkedList<>();
        if (root == null) {
            return rs;
        }
        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();
            List<Integer> temp = new ArrayList<>();
            while (n > 0) {
                TreeNode treeNode = helper.removeFirst();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    helper.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                }
                n--;
            }

            memo.add(temp);
        }

        for (List<Integer> list : memo) {
            rs.add(list.get(list.size() - 1));
        }
        return rs;
    }
}
