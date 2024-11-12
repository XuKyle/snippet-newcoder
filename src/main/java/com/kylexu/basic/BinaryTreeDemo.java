package com.kylexu.basic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );

        TreeNode binaryTree = createBinaryTree(inputList);

        System.out.print("前序遍历:");
        preOrderTravel(binaryTree);
        System.out.println();

        System.out.print("前序遍历-堆栈: ");
        preOrderTravelWithStack(binaryTree);
        System.out.println();

        System.out.print("中序遍历:");
        inOrderTravel(binaryTree);
        System.out.println();

        System.out.print("中序遍历[stack] :");
        inOrderTravelWithStack(binaryTree);
        System.out.println();

        System.out.print("后序遍历:");
        postOrderTravel(binaryTree);
        System.out.println();

        System.out.print("后序遍历[stack]:");
        postOrderTravelWithStack(binaryTree);
        System.out.println();

        System.out.print("广度：");
        widthTravel(binaryTree);
        System.out.println();
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> data) {
        TreeNode node = null;
        if (data.isEmpty()) {
            return null;
        }
        Integer peeked = data.removeFirst();
        if (peeked != null) {
            node = new TreeNode(peeked);
            node.left = createBinaryTree(data);
            node.right = createBinaryTree(data);
        }
        return node;
    }

    public static void preOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTravel(node.left);
        preOrderTravel(node.right);
    }

    public static void preOrderTravelWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                System.out.print(current.data + " ");
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
    }


    public static void inOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.left);
        System.out.print(node.data + " ");
        inOrderTravel(node.right);
    }

    public static void inOrderTravelWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }

    public static void postOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTravel(node.left);
        postOrderTravel(node.right);
        System.out.print(node.data + " ");
    }

    public static void postOrderTravelWithStack(TreeNode node) {
        Stack<TreeNode> memo = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                memo.push(current);
                current = current.right;
            } else {
                current = stack.pop();
                current = current.left;
            }
        }
        while (!memo.isEmpty()) {
            System.out.print(memo.pop().data + " ");
        }
    }

    public static void widthTravel(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();

            if (peek != null) {
                System.out.print(peek.data + " ");

                queue.add(peek.left);
                queue.add(peek.right);
            }

        }
    }



}
