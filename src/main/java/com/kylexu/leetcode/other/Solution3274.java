package com.kylexu.leetcode.other;

public class Solution3274 {
    public static void main(String[] args) {
//        输入： coordinate1 = "a1", coordinate2 = "c3"
//
//        输出： true
//
//        解释：
//
//        两个方格均为黑色。
//
//        示例 2：
//
//        输入： coordinate1 = "a1", coordinate2 = "h3"

        String coordinate1 = "a1", coordinate2 = "c3";
        boolean b = new Solution3274().checkTwoChessboards(coordinate1, coordinate2);
        System.out.println("b = " + b);
    }

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return color(coordinate1).equals(color(coordinate2));
    }

    public String color(String coordinate1) {
//        a1
        char x = coordinate1.charAt(0);
        char y = coordinate1.charAt(1);
        if (x == 'a' || x == 'c' || x == 'e' || x == 'g') {
            if ((y - '0') % 2 == 1) {
                return "black";
            } else {
                return "white";
            }
        }

        if (x == 'b' || x == 'd' || x == 'f' || x == 'h') {
            if ((y - '0') % 2 == 0) {
                return "black";
            } else {
                return "white";
            }
        }

        return "";
    }
}
