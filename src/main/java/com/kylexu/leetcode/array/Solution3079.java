package com.kylexu.leetcode.array;

/**
 * 给你一个整数数组 nums ，数组中的元素都是 正 整数。定义一个加密函数 encrypt ，encrypt(x) 将一个整数 x 中 每一个 数位都用 x 中的 最大 数位替换。比方说 encrypt(523) = 555 且 encrypt(213) = 333 。
 * <p>
 * 请你返回数组中所有元素加密后的 和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：6
 * <p>
 * 解释：加密后的元素位 [1,2,3] 。加密元素的和为 1 + 2 + 3 == 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,21,31]
 * <p>
 * 输出：66
 * <p>
 * 解释：加密后的元素为 [11,22,33] 。加密元素的和为 11 + 22 + 33 == 66
 */
public class Solution3079 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int rs = new Solution3079().sumOfEncryptedInt(nums);
        System.out.println("rs = " + rs);
    }

    public int sumOfEncryptedInt(int[] nums) {
        int rs = 0;
        for (int num : nums) {
            rs += encrypt(num);
        }
        return rs;
    }

    private int encrypt(int i) {
        int max = 0;
        int cnt = 0;

        while (i != 0) {
            max = Math.max(max, i % 10);
            i = i / 10;
            cnt++;
        }

        int rs = 0;
        for (int j = 0; j < cnt; j++) {
            rs = rs * 10 + max;
        }

        return rs;
    }
}
