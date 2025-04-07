package com.kylexu.bean;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }



    /**
     * 广度优先便利
     *
     * @return
     */
    public List<Integer> widthTraverse() {
        return wTraverse(this);
    }

    private List<Integer> wTraverse(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rs = new ArrayList<>();

        if (treeNode == null) {
            return rs;
        }

        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode popped = queue.remove();
            rs.add(popped.val);
            if (popped.left != null) {
                queue.add(popped.left);
            }
            if (popped.right != null) {
                queue.add(popped.right);
            }
        }

        return rs;
    }

    public int depth() {
        return maxDepth(this);
    }

    private int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right)) + 1;
    }

    @Override
    public String toString() {
        return widthTraverse().stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
