package com.kylexu.leetcode.company.jd;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class Solution94 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new Solution94().inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        travel(root, rs);
        return rs;
    }

    public void travel(TreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }

        travel(root.left, rs);
        rs.add(root.val);
        travel(root.right, rs);
    }
}
