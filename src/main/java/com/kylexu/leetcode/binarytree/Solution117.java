package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.NodePro;

import java.util.LinkedList;

public class Solution117 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        NodePro nodePro1 = new NodePro(1);
        NodePro nodePro2 = new NodePro(2);
        NodePro nodePro3 = new NodePro(3);
        nodePro1.left = nodePro2;
        nodePro1.right = nodePro3;
        NodePro nodePro4 = new NodePro(4);
        NodePro nodePro5 = new NodePro(5);
        nodePro2.left = nodePro4;
        nodePro2.right = nodePro5;
        NodePro nodePro6 = new NodePro(6);
        NodePro nodePro7 = new NodePro(7);
        nodePro3.left = nodePro6;
        nodePro3.right = nodePro7;

        NodePro connect = new Solution116().connect(nodePro1);
        System.out.println("connect = " + connect);
    }

    public NodePro connect(NodePro root) {
        LinkedList<NodePro> helper = new LinkedList<>();

        if (root == null) {
            return root;
        }
        helper.add(root);

        while (!helper.isEmpty()) {
            int n = helper.size();

            for (int i = 0; i < n; i++) {
                NodePro current = helper.removeFirst();
                if (i != n - 1) {
                    current.next = helper.peekFirst();
                } else {
                    current.next = null;
                }

                if (current.left != null) {
                    helper.add(current.left);
                }
                if (current.right != null) {
                    helper.add(current.right);
                }
            }
        }


        return root;
    }
}
