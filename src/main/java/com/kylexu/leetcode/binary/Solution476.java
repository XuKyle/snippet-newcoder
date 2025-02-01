package com.kylexu.leetcode.binary;

public class Solution476 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(new Solution476().findComplement(num));
    }

    public int findComplement(int num) {
        StringBuilder rs = new StringBuilder();
        for (char c : Integer.toBinaryString(num).toCharArray()) {
            if (c == '0') {
                rs.append('1');
            } else {
                rs.append('0');
            }
        }
        return Integer.parseInt(rs.toString(), 2);
    }
}
