package com.kylexu.leetcode.company.jd;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution102 {
    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
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

    public void travel(TreeNode root, List<List<Integer>> rs, int level) {
        if (root == null) {
            return;
        }

        if (rs.size() <= level) {
            rs.add(new ArrayList<>());
        }

        rs.get(level).add(root.val);
        travel(root.left, rs, level + 1);
        travel(root.right, rs, level + 1);
    }
}
