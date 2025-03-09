package com.kylexu.leetcode.array;

public class Solution1385 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 5, 8};
        int[] arr2 = new int[]{10, 9, 1, 8};
        int d = 2;
        System.out.println(new Solution1385().findTheDistanceValue(arr1, arr2, d));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int rs = 0;

        for (int i : arr1) {
            boolean flag = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                rs++;
            }
        }

        return rs;
    }
}
