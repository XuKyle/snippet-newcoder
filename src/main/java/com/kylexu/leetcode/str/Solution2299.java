package com.kylexu.leetcode.str;

/**
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * <p>
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：password = "IloveLe3tcode!"
 * 输出：true
 * 解释：密码满足所有的要求，所以我们返回 true 。
 * 示例 2：
 * <p>
 * 输入：password = "Me+You--IsMyDream"
 * 输出：false
 * 解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
 * 示例 3：
 * <p>
 * 输入：password = "1aB!"
 * 输出：false
 * 解释：密码不符合长度要求。所以我们返回 false 。
 */
public class Solution2299 {
    public static void main(String[] args) {
        String password = "Me+You--IsMyDream";
        boolean b = new Solution2299().strongPasswordCheckerII(password);
        System.out.println("b = " + b);
    }

    public boolean strongPasswordCheckerII(String password) {
//         * 它有至少 8 个字符。
// * 至少包含 一个小写英文 字母。
// * 至少包含 一个大写英文 字母。
// * 至少包含 一个数字 。
// * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
// * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。

        if (password.length() < 8) {
            return false;
        }
        int lowerLetterCount = 0;
        int highLetterCount = 0;
        int numberLetterCount = 0;
        int specialLetterCount = 0;

        char lastChar = ' ';
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numberLetterCount++;
            } else if (c >= 'a' && c <= 'z') {
                lowerLetterCount++;
            } else if (c >= 'A' && c <= 'Z') {
                highLetterCount++;
            } else if ("!@#$%^&*()-+".indexOf(c) >= 0) {
                specialLetterCount++;
            }

            if (c == lastChar) {
                return false;
            }
            lastChar = c;
        }

        if (numberLetterCount == 0 || highLetterCount == 0 || lowerLetterCount == 0 || specialLetterCount == 0) {
            return false;
        }

        return true;
    }
}
