package com.kylexu.bean;

public class Pair {
    private Integer left;
    private Integer right;

    public Integer getNodeCount() {
        return this.right - this.left + 1;
    }

    public Pair() {
    }

    public Pair(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
