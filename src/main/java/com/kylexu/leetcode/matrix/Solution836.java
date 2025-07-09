package com.kylexu.leetcode.matrix;

public class Solution836 {
    public static void main(String[] args) {
//        输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};

        boolean rectangleOverlap = new Solution836().isRectangleOverlap(rec1, rec2);
        System.out.println("rectangleOverlap = " + rectangleOverlap);
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1XLeft = rec1[0];
        int rec2XRight = rec2[2];

        if (rec1XLeft >= rec2XRight) {
            return false;
        }

        int rec1XRight = rec1[2];
        int rec2XLeft = rec2[0];
        if (rec2XLeft >= rec1XRight) {
            return false;
        }

        int rec1YBottom = rec1[1];
        int rec2YTop = rec2[3];
        if (rec1YBottom >= rec2YTop) {
            return false;
        }

        int rec1YTop = rec1[3];
        int rec2YBottom = rec2[1];
        if (rec2YBottom >= rec1YTop) {
            return false;
        }

        return true;
    }
}
