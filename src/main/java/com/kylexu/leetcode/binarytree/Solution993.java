package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution993 {
    public static void main(String[] args) {
//        输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
        TreeNode root = TreeNodeTools.buildTree(Arrays.asList(1, 2, 3, null, 4));
        int x = 2;
        int y = 3;
        boolean cousins = new Solution993().isCousins(root, x, y);
        System.out.println("cousins = " + cousins);
    }

    List<List<Integer>> route = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root);

        if (root.val == x || root.val == y) {
            return false;
        }
//        System.out.println("route = " + route);

        int xLevel = 0;
        int xParent = -1;
        int yLevel = 0;
        int yParent = -1;
        for (List<Integer> values : route) {
            if (values.contains(x) && values.contains(y)) {
                return false;
            }

            for (int j = 0; j < values.size(); j++) {
                if (values.get(j) == x) {
                    xLevel = j;
                    xParent = values.get(j - 1);
                }
                if (values.get(j) == y) {
                    yLevel = j;
                    yParent = values.get(j - 1);
                }
            }
        }
//        System.out.println("xLevel = " + xLevel);
//        System.out.println("yLevel = " + yLevel);
//        System.out.println("xParent = " + xParent);
//        System.out.println("yParent = " + yParent);

        return xLevel == yLevel && xParent != yParent;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        if (root.left == null && root.right == null) {
            route.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        dfs(root.left);
        dfs(root.right);
        path.removeLast();
    }

}
