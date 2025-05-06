package com.kylexu.leetcode.array;

public class Solution2748 {
    public static void main(String[] args) {
        int[] nums = {31, 25, 72, 79, 74};
        int i = new Solution2748().countBeautifulPairs(nums);
        System.out.println("i = " + i);
    }

    public int countBeautifulPairs(int[] nums) {
        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            int firstLetter = String.valueOf(nums[i]).charAt(0) - '0';
            for (int j = i + 1; j < nums.length; j++) {
                if (gcd(firstLetter, nums[j] % 10) == 1) {
                    rs++;
                }
            }
        }

        return rs;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
