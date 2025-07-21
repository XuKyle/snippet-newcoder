package com.kylexu.leetcode.array;

public class Solution1456 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int i = new Solution1456().maxVowels(s, k);
        System.out.println("i = " + i);
    }

    public int maxVowels(String s, int k) {
        int rs = 0;

        char[] array = s.toCharArray();
        int l = 0;
        int vowels = 0;
        for (int i = 0; i < array.length; i++) {
//            a, e, i, o, u
            if (array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u') {
                vowels++;
            }

            if (i < k - 1) {
                continue;
            }

            rs = Math.max(rs, vowels);
            l = i - k + 1;
            if (array[l] == 'a' || array[l] == 'e' || array[l] == 'i' || array[l] == 'o' || array[l] == 'u') {
                vowels--;
            }
        }

        return rs;
    }
}
