package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class Solution113 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        int targetSum = 22;
        List<List<Integer>> rs = new Solution113().pathSum(treeNode, targetSum);
        System.out.println("rs = " + rs);

        List<List<Integer>> rs1 = new Solution113().pathSumV1(treeNode, targetSum);
        System.out.println("rs1 = " + rs1);
    }

    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSumV1(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return rs;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            rs.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rs = new ArrayList<>();

        LinkedList<TreeNode> helper = new LinkedList<>();
        LinkedList<List<Integer>> memo = new LinkedList<>();

        helper.add(root);
        memo.add(new ArrayList<>() {{
            add(5);
        }});

        while (!helper.isEmpty()) {
            int n = helper.size();
            while (n > 0) {
                TreeNode treeNode = helper.removeFirst();
                List<Integer> holder = memo.removeFirst();
                int sum = 0;
                for (Integer i : holder) {
                    sum += i;
                }

                if (treeNode.left == null && treeNode.right == null) {
                    if (sum == targetSum) {
                        rs.add(holder);
                    }
                }

                if (treeNode.left != null) {
                    helper.add(treeNode.left);

                    ArrayList<Integer> integers = new ArrayList<>(holder);
                    integers.add(treeNode.left.val);
                    memo.add(integers);
                }
                if (treeNode.right != null) {
                    helper.add(treeNode.right);

                    ArrayList<Integer> integers = new ArrayList<>(holder);
                    integers.add(treeNode.right.val);
                    memo.add(integers);
                }
                n--;
            }
        }

        return rs;
    }
}
