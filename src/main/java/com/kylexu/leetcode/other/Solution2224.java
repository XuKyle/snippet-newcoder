package com.kylexu.leetcode.other;

/**
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * <p>
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 * 示例 1：
 * <p>
 * 输入：current = "02:30", correct = "04:35"
 * 输出：3
 * 解释：
 * 可以按下述 3 步操作将 current 转换为 correct ：
 * - 为 current 加 60 分钟，current 变为 "03:30" 。
 * - 为 current 加 60 分钟，current 变为 "04:30" 。
 * - 为 current 加 5 分钟，current 变为 "04:35" 。
 * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
 * <p>
 * 输入：current = "11:00", correct = "11:01"
 * 输出：1
 * 解释：只需要为 current 加一分钟，所以最小操作数是 1 。
 * <p>
 * <p>
 * "09:41"
 * correct =
 * "10:34"
 */
public class Solution2224 {
    public static void main(String[] args) {
        String current = "02:30";
        String correct = "04:35";
        System.out.println(new Solution2224().convertTime(current, correct));
    }

    public int convertTime(String current, String correct) {
        int hourCurrent = Integer.parseInt(current.split(":")[0]);
        int minuteCurrent = Integer.parseInt(current.split(":")[1]);

        int hourCorrect = Integer.parseInt(correct.split(":")[0]);
        int minuteCorrect = Integer.parseInt(correct.split(":")[1]);

        int rs = 0;


        if (minuteCurrent > minuteCorrect) {
            minuteCurrent -= 60;
            hourCurrent++;
        }

        while (minuteCurrent != minuteCorrect) {
            int gap = minuteCorrect - minuteCurrent;
            // 1、5、15
            if (gap >= 15) {
                minuteCurrent += 15;
            } else if (gap >= 5) {
                minuteCurrent += 5;
            } else if (gap >= 1) {
                minuteCurrent += 1;
            }
            rs++;
        }

        while (hourCurrent != hourCorrect) {
            hourCurrent++;
            hourCurrent %= 24;
            rs++;
        }

        return rs;
    }
}
