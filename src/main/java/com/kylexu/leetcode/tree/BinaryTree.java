package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class BinaryTree {
    private TreeNode root;

    public BinaryTree(int[] nums) {
        this.root = createTree(nums);
    }

    private TreeNode createTree(int[] nums) {
        return create(nums, 0);
    }

    private TreeNode create(int[] nums, int pos) {
        if (pos < nums.length) {
            TreeNode treeNode = new TreeNode(nums[pos]);
            treeNode.left = create(nums, 2 * pos + 1);
            treeNode.right = create(nums, 2 * pos + 2);
            return treeNode;
        }
        return null;
    }

    public List<Integer> preOrderTravel() {
        List<Integer> rs = new ArrayList<>();
        preOrderTravel(root, rs);
        return rs;
    }

    private void preOrderTravel(TreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }

        rs.add(root.val);
        preOrderTravel(root.left, rs);
        preOrderTravel(root.right, rs);
    }

    private List<Integer> widthTravel() {
        List<Integer> rs = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            rs.add(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        BinaryTree binaryTree = new BinaryTree(nums);
        System.out.println(binaryTree.preOrderTravel());
        System.out.println(binaryTree.widthTravel());
    }
}
