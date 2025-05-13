package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：num1 = 1, num2 = 10, num3 = 1000
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 补前导 0 后，num1 变为 "0001" ，num2 变为 "0010" ，num3 保持不变，为 "1000" 。
 * <p>
 * 数字答案 key 的第 1 个数位为 min(0, 0, 1) 。
 * 数字答案 key 的第 2 个数位为 min(0, 0, 0) 。
 * 数字答案 key 的第 3 个数位为 min(0, 1, 0) 。
 * 数字答案 key 的第 4 个数位为 min(1, 0, 0) 。
 * 所以数字答案为 "0000" ，也就是 0 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： num1 = 987, num2 = 879, num3 = 798
 * <p>
 * 输出：777
 * <p>
 * 示例 3：
 * <p>
 * 输入：num1 = 1, num2 = 2, num3 = 3
 * <p>
 * 输出：1
 */
public class Solution3270 {
    public static void main(String[] args) {
        int num1 = 987, num2 = 879, num3 = 798;
        int i = new Solution3270().generateKey(num1, num2, num3);
        System.out.println("i = " + i);
    }

    public int generateKey(int num1, int num2, int num3) {
        String s1 = String.format("%04d", num1);
        String s2 = String.format("%04d", num2);
        String s3 = String.format("%04d", num3);

        int rs = 0;

        for (int i = 0; i < 4; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s3.charAt(i);

            rs = rs * 10 + Character.getNumericValue(Math.min(c1, Math.min(c2, c3)));
        }

        return rs;
    }
}
