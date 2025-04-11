package com.kylexu.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class NTreeNode {
    public int val;

    public List<NTreeNode> children;

    public NTreeNode() {
    }

    public NTreeNode(int val) {
        this.val = val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        this.val = _val;
        this.children = _children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        

        return "NTreeNode{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}
