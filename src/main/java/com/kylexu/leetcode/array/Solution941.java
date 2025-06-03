package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：arr = [2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [0,3,2,1]
 * 输出：true
 */
public class Solution941 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 5};
        boolean b = new Solution941().validMountainArray(arr);
        System.out.println("b = " + b);
    }

    public boolean validMountainArray(int[] arr) {
        boolean findTheTop = false;

        if (arr.length < 2) {
            return false;
        }

        if (arr[0] >= arr[1]) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return false;
            }

            if (!findTheTop) {
                if (arr[i - 1] > arr[i]) {
                    findTheTop = true;
                }
            } else {
                if (arr[i - 1] < arr[i]) {
                    return false;
                }
            }
        }

        return findTheTop;
    }
}
