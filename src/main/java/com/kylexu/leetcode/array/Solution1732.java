package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * 示例 2：
 * <p>
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 */
public class Solution1732 {
    public static void main(String[] args) {
        int[] gain = new int[]{-4, -3, -2, -1, 4, 3, 2};
        System.out.println(new Solution1732().largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int max = 0;

        int current = 0;
        for (int g : gain) {
            current = current + g;
            max = Math.max(max, current);
        }

        return max;
    }
}
