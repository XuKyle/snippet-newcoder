package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：low = 1, high = 100
 * 输出：9
 * 解释：在 1 到 100 范围内共有 9 个对称整数：11、22、33、44、55、66、77、88 和 99 。
 * 示例 2：
 * <p>
 * 输入：low = 1200, high = 1230
 * 输出：4
 * 解释：在 1200 到 1230 范围内共有 4 个对称整数：1203、1212、1221 和 1230 。
 */
public class Solution2843 {
    public static void main(String[] args) {
        int low = 1200;
        int high = 1230;
        System.out.println(new Solution2843().countSymmetricIntegers(low, high));
    }

    public int countSymmetricIntegers(int low, int high) {
        int rs = 0;

        for (int i = low; i <= high; i++) {
            String current = String.valueOf(i);
            int n = current.length();
            if (n % 2 == 0) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j < n / 2) {
                        sum += current.charAt(j);
                    } else {
                        sum -= current.charAt(j);
                    }
                }
                if (sum == 0) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
