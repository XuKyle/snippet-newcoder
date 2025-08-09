package com.kylexu.leetcode.num;

public class Solution1009 {
    public static void main(String[] args) {
        int n = 5;
        int i = new Solution1009().bitwiseComplement(n);
        System.out.println("i = " + i);
    }

    public int bitwiseComplement(int n) {
        char[] charArray = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                charArray[i] = '0';
            } else {
                charArray[i] = '1';
            }
        }
        return Integer.parseInt(new String(charArray), 2);
    }
}
