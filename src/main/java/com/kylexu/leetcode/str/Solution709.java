package com.kylexu.leetcode.str;

public class Solution709 {
    public static void main(String[] args) {
//        示例 1：
//
//        输入：s = "Hello"
//        输出："hello"
//        示例 2：
//
//        输入：s = "here"
//        输出："here"
//        示例 3：
//
//        输入：s = "LOVELY"
//        输出："lovely"

        String str = "LOVELY";
        System.out.println(new Solution709().toLowerCase(str));
    }

    public String toLowerCase(String s) {
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] = (char) (array[i] + 32);
            }
        }
        return new String(array);
    }
}
