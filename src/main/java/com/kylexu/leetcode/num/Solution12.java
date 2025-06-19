package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：num = 3749
 * <p>
 * 输出： "MMMDCCXLIX"
 * <p>
 * 解释：
 * <p>
 * 3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
 * 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
 * 40 = XL 由于 50 (L) 减 10 (X)
 * 9 = IX 由于 10 (X) 减 1 (I)
 * 注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
 * 示例 2：
 * <p>
 * 输入：num = 58
 * <p>
 * 输出："LVIII"
 * <p>
 * 解释：
 * <p>
 * 50 = L
 * 8 = VIII
 * 示例 3：
 * <p>
 * 输入：num = 1994
 * <p>
 * 输出："MCMXCIV"
 * <p>
 * 解释：
 * <p>
 * 1000 = M
 * 900 = CM
 * 90 = XC
 * 4 = IV
 */
public class Solution12 {
    public static void main(String[] args) {
// * 输入：num = 3749
//                *
//                * 输出： "MMMDCCXLIX"
        int num = 3749;
        String rs = new Solution12().intToRoman(num);
        System.out.println("rs = " + rs);
    }

    public String intToRoman(int num) {
        StringBuilder rs = new StringBuilder();

//        I	1
//        V	5
//        X	10
//        L	50
//        C	100
//        D	500
//        M	1000


        String[] mark = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                rs.append(mark[i]);
            }
        }

        return rs.toString();
    }
}
