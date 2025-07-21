package com.kylexu.leetcode.array;

public class Solution1343 {
    public static void main(String[] args) {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3;
        int threshold = 5;
        int i = new Solution1343().numOfSubarrays(arr, k, threshold);
        System.out.println("i = " + i);
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int rs = 0;

        int sum = 0;
        int l = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            sum += current;

            if (i < k - 1) {
                continue;
            }

            if (sum >= k * threshold) {
                rs++;
            }

            sum -= arr[l];
            l++;
        }


        return rs;
    }
}
