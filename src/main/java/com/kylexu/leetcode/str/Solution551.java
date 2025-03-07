package com.kylexu.leetcode.str;

/*
给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：

'A'：Absent，缺勤
'L'：Late，迟到
'P'：Present，到场
如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：

按 总出勤 计，学生缺勤（'A'）严格 少于两天。
学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 */
public class Solution551 {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(new Solution551().checkRecord(s));
    }

    /**
     * 示例 1：
     *
     * 输入：s = "PPALLP"
     * 输出：true
     * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
     * 示例 2：
     *
     * 输入：s = "PPALLL"
     * 输出：false
     * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int absentDayCnt = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (current == 'A') {
                absentDayCnt++;
                if (absentDayCnt >= 2) {
                    return false;
                }
            } else if (current == 'L') {
                int end = i + 2;
                if (end < n) {
                    if (s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
