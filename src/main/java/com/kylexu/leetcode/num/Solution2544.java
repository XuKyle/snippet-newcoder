package com.kylexu.leetcode.num;

/**
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 示例 1：
 * <p>
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * 示例 2：
 * <p>
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * 示例 3：
 * <p>
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 */
public class Solution2544 {
    public int alternateDigitSum(int n) {
        int rs = 0;
        boolean flag = true;
        for (char c : String.valueOf(n).toCharArray()) {
            if (flag) {
                rs += Character.getNumericValue(c);
            } else {
                rs -= Character.getNumericValue(c);
            }
            flag = !flag;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2544().alternateDigitSum(886996));
    }
}
