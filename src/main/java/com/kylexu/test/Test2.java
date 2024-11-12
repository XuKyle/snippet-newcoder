package com.kylexu.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>();
        Node<Integer> tree = new Test2().createTree2(root, 3);
        System.out.println("tree = " + tree);
    }

    public Node<Integer> createTree2(Node<Integer> root, int n) {
        if (n == 1) {
            return new Node<>();
        }

        while (n > 1) {
            n = n - 1;
            root.left = createTree2(root, n);
            root.right = createTree2(root, n);
        }

        return root;
    }


    public Node<Integer> createTree(int n) {
        int nodeCount = 2 * n + 1;
        List<Node<Integer>> nodeList = new ArrayList<>();

        for (int i = 0; i < nodeCount; i++) {
            Node<Integer> node = new Node<>();
            nodeList.add(node);
        }

        for (int i = 0; i < nodeCount; i++) {
            Node<Integer> currentNode = nodeList.get(i);
            if (i != 0) {
                int parentIndex = i / 2;
                currentNode.parent = nodeList.get(parentIndex);
            }

            if (i < nodeCount / 2) {
                currentNode.left = nodeList.get(2 * i + 1);
                currentNode.right = nodeList.get(2 * i + 2);
            }
        }

        return nodeList.get(0);
    }
}
