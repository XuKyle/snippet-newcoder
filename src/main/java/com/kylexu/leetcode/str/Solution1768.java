package com.kylexu.leetcode.str;

/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 * <p>
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 */
public class Solution1768 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(new Solution1768().mergeAlternately(word1, word2));

    }

    public String mergeAlternately(String word1, String word2) {
        int maxLength = Math.max(word1.length(), word2.length());

        StringBuilder rs = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                rs.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                rs.append(word2.charAt(i));
            }
        }

        return rs.toString();
    }
}
