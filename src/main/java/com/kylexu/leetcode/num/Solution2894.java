package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：n = 10, m = 3
 * 输出：19
 * 解释：在这个示例中：
 * - 范围 [1, 10] 内无法被 3 整除的整数为 [1,2,4,5,7,8,10] ，num1 = 这些整数之和 = 37 。
 * - 范围 [1, 10] 内能够被 3 整除的整数为 [3,6,9] ，num2 = 这些整数之和 = 18 。
 * 返回 37 - 18 = 19 作为答案。
 * 示例 2：
 * <p>
 * 输入：n = 5, m = 6
 * 输出：15
 * 解释：在这个示例中：
 * - 范围 [1, 5] 内无法被 6 整除的整数为 [1,2,3,4,5] ，num1 = 这些整数之和 =  15 。
 * - 范围 [1, 5] 内能够被 6 整除的整数为 [] ，num2 = 这些整数之和 = 0 。
 * 返回 15 - 0 = 15 作为答案。
 * 示例 3：
 * <p>
 * 输入：n = 5, m = 1
 * 输出：-15
 * 解释：在这个示例中：
 * - 范围 [1, 5] 内无法被 1 整除的整数为 [] ，num1 = 这些整数之和 = 0 。
 * - 范围 [1, 5] 内能够被 1 整除的整数为 [1,2,3,4,5] ，num2 = 这些整数之和 = 15 。
 * 返回 0 - 15 = -15 作为答案。
 */
public class Solution2894 {
    public static void main(String[] args) {
        int n = 10, m = 3;
        int rs = new Solution2894().differenceOfSums(n, m);
        System.out.println("rs = " + rs);
    }

    public int differenceOfSums(int n, int m) {
        int a = 0;
        int b = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                b += i;
            } else {
                a += i;
            }
        }

        return a - b;
    }
}
