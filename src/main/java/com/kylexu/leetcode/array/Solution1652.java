package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 * 示例 2：
 * <p>
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 * 示例 3：
 * <p>
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 */
public class Solution1652 {
    public static void main(String[] args) {
        int[] code = new int[]{2, 4, 9, 3};
        int k = -2;
        int[] decrypt = new Solution1652().decrypt(code, k);
        System.out.println("decrypt = " + Arrays.toString(decrypt));
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] rs = new int[n];

        for (int i = 0; i < rs.length; i++) {
            if (k == 0) {
                rs[i] = 0;
            } else if (k > 0) {
                int sum = 0;
                for (int j = i + 1; j <= i + k; j++) {
                    sum += code[j % n];
                }
                rs[i] = sum;
            } else {
                int sum = 0;

                for (int j = i - 1; j >= i + k; j--) {
                    int index = j;
                    while (index < 0) {
                        index += n;
                    }
                    sum += code[index % n];
                }
                rs[i] = sum;
            }
        }

        return rs;
    }
}
