package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入: password = "s3cur1tyC0d3", target = 4
 * 输出: "r1tyC0d3s3cu"
 * 示例 2：
 * <p>
 * 输入: password = "lrloseumgh", target = 6
 * 输出: "umghlrlose"
 */
public class LCRSolution182 {
    public static void main(String[] args) {
        String password = "lrloseumgh";
        int target = 6;
        System.out.println(new LCRSolution182().dynamicPassword(password, target));
    }

    public String dynamicPassword(String password, int target) {
        return password.substring(target) + password.substring(0, target);
    }
}
