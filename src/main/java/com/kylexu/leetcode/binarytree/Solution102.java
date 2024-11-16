package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution102 {
    public static void main(String[] args) {
//        输入：root = [3,9,20,null,null,15,7]
//        输出：[[3],[9,20],[15,7]]
//        示例 2：
//
//        输入：root = [1]
//        输出：[[1]]

        TreeNode treeNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(new Solution102().levelOrder(treeNode));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        int level = 0;
        travel(root, rs, level);
        return rs;
    }

    public void travel(TreeNode node, List<List<Integer>> rs, int level) {
        if (node == null) {
            return;
        }

        if (rs.size() <= level) {
            rs.add(new ArrayList<>());
        }

        rs.get(level).add(node.val);

        travel(node.left, rs, level + 1);
        travel(node.right, rs, level + 1);
    }
}
