package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 3：
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 */
public class Solution1640 {
    public static void main(String[] args) {
        int[] arr = new int[]{15, 88};
        int[][] pieces = new int[][]{
                {88},
                {15}
        };
        System.out.println(new Solution1640().canFormArray(arr, pieces));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        //todo
        return false;
    }
}
