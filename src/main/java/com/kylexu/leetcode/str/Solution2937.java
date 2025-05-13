package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入：s1 = "abc"，s2 = "abb"，s3 = "ab"
 * 输出：2
 * 解释：对 s1 和 s2 进行一次操作后，可以得到三个相等的字符串。
 * 可以证明，不可能用少于两次操作使它们相等。
 * 示例 2：
 * <p>
 * 输入：s1 = "dac",s2 = "bac",s3 = "cac"
 * 输出：-1
 * 解释：因为 s1 和 s2 的最左位置上的字母不相等，所以无论进行多少次操作，它们都不可能相等。因此答案是 -1 。
 */
public class Solution2937 {
    public static void main(String[] args) {
        String s1 = "ca", s2 = "cccabb", s3 = "cb";
        int minimumOperations = new Solution2937().findMinimumOperations(s1, s2, s3);
        System.out.println("minimumOperations = " + minimumOperations);
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int rs = 0;
        int n = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        int m = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                // do nothing
            } else {
                if (i < 1) {
                    return -1;
                } else {
                    m = i;
                    break;
                }
            }
        }

        if (m == -1) {
            m = n;
        }

        return s1.length() - m + s2.length() - m + s3.length() - m;
    }
}
