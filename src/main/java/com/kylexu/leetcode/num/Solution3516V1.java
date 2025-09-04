package com.kylexu.leetcode.num;

public class Solution3516V1 {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);

        if (a == b) {
            return 0;
        } else if (a > b) {
            return 2;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int x = 2, y = 7, z = 4;
        int closest = new Solution3516V1().findClosest(x, y, z);
        System.out.println("closest = " + closest);
    }
}
