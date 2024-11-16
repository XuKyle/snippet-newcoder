package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public static void main(String[] args) {
//        输入：root = [1,null,2,3]
//        输出：[1,3,2]
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new Solution94().inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        traveral(root, rs);
        return rs;
    }

    private void traveral(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traveral(node.left, list);
        list.add(node.val);
        traveral(node.right, list);
    }
}
