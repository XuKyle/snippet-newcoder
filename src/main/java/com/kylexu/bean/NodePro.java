package com.kylexu.bean;

public class NodePro {
    public int val;
    public NodePro left;
    public NodePro right;
    public NodePro next;

    public NodePro() {}

    public NodePro(int _val) {
        val = _val;
    }

    public NodePro(int _val, NodePro _left, NodePro _right, NodePro _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "NodePro{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
