package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入： n = 13, k = 4
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * 最初，n 和 k 的二进制表示分别为 n = (1101)2 和 k = (0100)2，
 * <p>
 * 我们可以改变 n 的第一位和第四位。结果整数为 n = (0100)2 = k。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 21, k = 21
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * n 和 k 已经相等，因此不需要更改。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 14, k = 13
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * 无法使 n 等于 k。
 */
public class Solution3226 {
    public static void main(String[] args) {
        int n = 14, k = 13;
        int rs = new Solution3226().minChanges(n, k);
        System.out.println("rs = " + rs);
    }

    public int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        }

        String binaryStringN = Integer.toBinaryString(n);
        String binaryStringK = Integer.toBinaryString(k);

        System.out.println("binaryStringN = " + binaryStringN);
        System.out.println("binaryStringK = " + binaryStringK);

        int max = Math.max(binaryStringK.length(), binaryStringN.length());
        int rs = 0;
        if (binaryStringK.length() > binaryStringN.length()) {
            for (int i = 0; i < binaryStringK.length() - binaryStringN.length(); i++) {
                if (binaryStringK.charAt(i) == '1') {
                    return -1;
                }
            }
        } else {
            for (int i = 0; i < max; i++) {
                int jn = binaryStringN.length() - i - 1;
                int jk = binaryStringK.length() - i - 1;

                if (jk < 0) {
                    if (binaryStringN.charAt(jn) == '1') {
                        rs++;
                    }
                } else {
                    if (binaryStringN.charAt(jn) == '0' && binaryStringK.charAt(jk) == '1') {
                        return -1;
                    } else if (binaryStringN.charAt(jn) == '1' && binaryStringK.charAt(jk) == '0') {
                        rs++;
                    }
                }
            }
        }


        return rs;
    }
}
