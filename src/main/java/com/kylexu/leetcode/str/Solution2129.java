package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * 输入：title = "capiTalIze tHe titLe"
 * 输出："Capitalize The Title"
 * 解释：
 * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
 * 示例 2：
 * <p>
 * 输入：title = "First leTTeR of EACH Word"
 * 输出："First Letter of Each Word"
 * 解释：
 * 单词 "of" 长度为 2 ，所以它保持完全小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * 示例 3：
 * <p>
 * 输入：title = "i lOve leetcode"
 * 输出："i Love Leetcode"
 * 解释：
 * 单词 "i" 长度为 1 ，所以它保留小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 */
public class Solution2129 {
    public static void main(String[] args) {
        String title = "i lOve leetcode";
        String s = new Solution2129().capitalizeTitle(title);
        System.out.println("s = " + s);
    }

    public String capitalizeTitle(String title) {
        StringBuilder rs = new StringBuilder();

        String[] split = title.split(" ");

        for (int i = 0; i < split.length; i++) {
            String word = split[i];

            String lowerCase = word.toLowerCase();
            if (lowerCase.length() <= 2) {
                rs.append(lowerCase);
            } else {
                rs.append(lowerCase.substring(0, 1).toUpperCase())
                        .append(lowerCase.substring(1));
            }

            if (i != split.length - 1) {
                rs.append(" ");
            }
        }

        return rs.toString();
    }
}
