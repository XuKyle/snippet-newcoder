package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 */
public class Solution257 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(new Integer[]{1, 2, 3, null, 5});
        System.out.println(new Solution257().binaryTreePaths(treeNode));
        System.out.println(new Solution257().binaryTreePathsV1(treeNode));
        System.out.println(new Solution257().binaryTreePathsV2(treeNode));
    }

    public List<String> binaryTreePathsV2(TreeNode root) {
        List<String> rs = new ArrayList<>();
        List<String> path = new ArrayList<>();
        travel(root, rs, path);
        return rs;
    }

    private void travel(TreeNode node, List<String> rs, List<String> path) {
        if (node == null) {
            return;
        }

        path.add(String.valueOf(node.val));

        if (node.left == null && node.right == null) {
            var sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i != path.size() - 1) {
                    sb.append("->");
                }
            }
            rs.add(sb.toString());
            return;
        }

        if (node.left != null) {
            travel(node.left, rs, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            travel(node.right, rs, path);
            path.remove(path.size() - 1);
        }
    }


    List<String> rs = new ArrayList<>();

    public List<String> binaryTreePathsV1(TreeNode root) {
        recursionTreeV1(root, "");
        return rs;
    }

    private void recursionTreeV1(TreeNode node, String str) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            rs.add(str + String.valueOf(node.val));
        }

        String pre = str + node.val + "->";
        recursionTreeV1(node.left, pre);
        recursionTreeV1(node.right, pre);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rs = new ArrayList<>();

        if (root == null) {
            return rs;
        }

        LinkedList<TreeNode> helper = new LinkedList<>();
        LinkedList<String> memo = new LinkedList<>();
        helper.add(root);
        memo.add(String.valueOf(root.val));

        while (!helper.isEmpty()) {
            int n = helper.size();
            while (n > 0) {
                TreeNode current = helper.removeFirst();
                String currentStr = memo.removeFirst();

                if (current.left == null && current.right == null) {
                    rs.add(currentStr);
                }

                if (current.left != null) {
                    helper.add(current.left);
                    memo.add(currentStr + "->" + current.left.val);
                }
                if (current.right != null) {
                    helper.add(current.right);
                    memo.add(currentStr + "->" + current.right.val);
                }
                n--;
            }
        }

        return rs;
    }
}
