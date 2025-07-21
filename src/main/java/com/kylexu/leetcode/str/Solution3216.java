package com.kylexu.leetcode.str;

public class Solution3216 {
    public static void main(String[] args) {
        String s = "45320";
        String smallestString = new Solution3216().getSmallestString(s);
        System.out.println("smallestString = " + smallestString);
    }

    public String getSmallestString(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < n - 1; i++) {
            if (sameOdd(charArray[i], charArray[i + 1])) {
                if (charArray[i] > charArray[i + 1]) {
                    char temp = charArray[i + 1];
                    charArray[i + 1] = charArray[i];
                    charArray[i] = temp;
                    break;
                }
            }
        }

        return new String(charArray);
    }

    private boolean sameOdd(char a, char b) {
        return (a - '0') % 2 == (b - '0') % 2;
    }
}
