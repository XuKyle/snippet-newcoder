package com.kylexu.leetcode.array;

/**
 * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
 * <p>
 * 示例 1:
 * <p>
 * 输入: records = [0,1,2,3,5]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: records = [0, 1, 2, 3, 4, 5, 6, 8]
 * 输出: 7
 */
public class SolutionLCR173 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 8};
        System.out.println(new SolutionLCR173().takeAttendance(nums));
    }

    public int takeAttendance(int[] records) {
        for (int i = 0; i < records.length; i++) {
            if (records[i] != i) {
                return i;
            }
        }
        return records.length;
    }
}
