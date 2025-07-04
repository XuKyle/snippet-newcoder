package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1448 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeTools.buildTree(Arrays.asList(3, 1, 4, 3, null, 1, 5));
        int i = new Solution1448().goodNodes(root);
        System.out.println("i = " + i);
    }


    public int goodNodes(TreeNode root) {
        travel(root);

        System.out.println("route = " + route);
        return 0;
    }

    List<List<Integer>> route = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        // 如果是叶子节点
        if (root.left == null && root.right == null) {
            route.add(new ArrayList<>(path));
            // 返回之前移除当前叶子节点
            path.removeLast();
            return;
        }

        if (root.left != null) {
            travel(root.left);
        }
        if (root.right != null) {
            travel(root.right);
        }
        path.removeLast();
    }
}
