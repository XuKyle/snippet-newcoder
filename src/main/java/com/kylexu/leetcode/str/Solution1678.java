package com.kylexu.leetcode.str;

/**
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * <p>
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 */
public class Solution1678 {
    public static void main(String[] args) {
//        String command = "G()(al)";
//        String command = "G()()()()(al)";
        String command = "(al)G(al)()()G";
        System.out.println(new Solution1678().interpret(command));
    }

    public String interpret(String command) {
        int n = command.length();

        StringBuilder rs = new StringBuilder();
        int start = 0;
        while (start < n) {
            String currentStr = command.substring(start);
            if (currentStr.startsWith("G")) {
                rs.append("G");
                start += 1;
            } else if (currentStr.startsWith("()")) {
                rs.append("o");
                start += 2;
            } else if (currentStr.startsWith("(al)")) {
                rs.append("al");
                start += 4;
            }
        }

        return rs.toString();
    }
}
