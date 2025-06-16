package com.kylexu.leetcode.str;

public class Solution1869 {
    public static void main(String[] args) {
        String s = "1101";
        boolean b = new Solution1869().checkZeroOnes(s);
        System.out.println("b = " + b);
    }

    public boolean checkZeroOnes(String s) {

        if (s.length() == 1) {
            return s.charAt(0) == '1';
        }

        int oneLength = 0;
        int zeroLength = 0;

        int startIndex = 0;

        tag:
        while (startIndex < s.length()) {
            if (s.charAt(startIndex) == '1') {
                if (startIndex == s.length() - 1) {
                    oneLength = Math.max(oneLength, 1);
                    break tag;
                }

                for (int j = startIndex + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '1' && j == s.length() - 1) {
                        oneLength = Math.max(oneLength, j - startIndex + 1);
                        break tag;
                    }
                    if (s.charAt(j) != '1') {
                        oneLength = Math.max(oneLength, j - startIndex);
                        startIndex = j;
                        break;
                    }
                }
            }

            if (s.charAt(startIndex) == '0') {
                if (startIndex == s.length() - 1) {
                    zeroLength = Math.max(zeroLength, 1);
                    break tag;
                }
                for (int j = startIndex + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '0' && j == s.length() - 1) {
                        zeroLength = Math.max(zeroLength, j - startIndex + 1);
                        break tag;
                    }
                    if (s.charAt(j) != '0') {
                        zeroLength = Math.max(zeroLength, j - startIndex);
                        startIndex = j;
                        break;
                    }
                }
            }
//            System.out.println("startIndex = " + startIndex);
        }

//        System.out.println("zeroLength = " + zeroLength);
//        System.out.println("oneLength = " + oneLength);

        return oneLength > zeroLength;
    }
}
