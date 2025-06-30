package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 8 [4] 2 1
 * [32] [16] 8 4 [2] [1]
 * 例如，下面的二进制手表读取 "4:51" 。
 * <p>
 * <p>
 * 小时不会以零开头：
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 */

/**
 * 示例 1：
 * <p>
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 示例 2：
 * <p>
 * 输入：turnedOn = 9
 * 输出：[]
 */
public class Solution401 {
    public static void main(String[] args) {
        int turnedOn = 1;
        List<String> strings = new Solution401().readBinaryWatch(turnedOn);
        System.out.println("strings = " + strings);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> rs = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count(i) + count(j) == turnedOn) {
                    rs.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }

        return rs;
    }

    private int count(int i) {
        return Integer.bitCount(i);
    }
}
