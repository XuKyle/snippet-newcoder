package com.kylexu.leetcode.tree;

import com.kylexu.basic.BinaryTreeDemo;
import com.kylexu.bean.ListNode;
import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution113 {

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    private void dfs(TreeNode root, int left) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        left = left - root.val;
        if (root.left == null && root.right == null && left == 0) {
            ret.add(new ArrayList<>(path));
        }

        dfs(root.left, left);
        dfs(root.right, left);
        path.removeLast();
    }

    public static void main(String[] args) {
//        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//        输出：[[5,4,11,2],[5,8,4,5]]

        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)
                        ),
                        null
                ),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1)
                        )
                )
        );

        System.out.println(new Solution113().pathSum(treeNode, 22));
    }
}
