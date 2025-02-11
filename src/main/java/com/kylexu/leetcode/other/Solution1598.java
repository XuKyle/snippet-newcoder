package com.kylexu.leetcode.other;

/**
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 */
public class Solution1598 {
    public static void main(String[] args) {
        String[] log = new String[]{"d1/", "../", "../", "../"};
        int i = new Solution1598().minOperations(log);
        System.out.println("i = " + i);
    }

    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            switch (log) {
                case "../":
                    if (depth > 0) {
                        depth--;
                    }
                    break;
                case "./":
                    break;
                default:
                    depth++;
            }
        }
        return depth;
    }
}
