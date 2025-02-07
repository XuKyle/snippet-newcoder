package com.kylexu.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 */

/**
 * //输入：columnNumber = 1
 * //输出："A"
 * //
 * // 示例 2：
 * //输入：columnNumber = 28
 * //输出："AB"
 * //
 * //
 * // 示例 3：
 * //输入：columnNumber = 701
 * //输出："ZY"
 * //
 * //
 * // 示例 4：
 * //输入：columnNumber = 2147483647
 * //输出："FXSHRXW"
 */
//
//columnNumber =
//        52
//
//        添加到测试用例
//                输出
//"Bllun"
//        预期结果
//"AZ"
public class Solution168 {
    public static void main(String[] args) {
        int columnNumber = 2147483647;
        System.out.println(new Solution168().convertToTitle(columnNumber));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder rs = new StringBuilder();
        while (columnNumber-- != 0) {
            int left = columnNumber % 26;
            rs.append(Character.toString(left + 'A'));
            columnNumber = columnNumber / 26;
        }
        return rs.reverse().toString();
    }
}
