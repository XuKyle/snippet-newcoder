package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：seats = [3,1,5], students = [2,7,4]
 * 输出：4
 * 解释：学生移动方式如下：
 * - 第一位学生从位置 2 移动到位置 1 ，移动 1 次。
 * - 第二位学生从位置 7 移动到位置 5 ，移动 2 次。
 * - 第三位学生从位置 4 移动到位置 3 ，移动 1 次。
 * 总共 1 + 2 + 1 = 4 次移动。
 * 示例 2：
 * <p>
 * 输入：seats = [4,1,5,9], students = [1,3,2,6]
 * 输出：7
 * 解释：学生移动方式如下：
 * - 第一位学生不移动。
 * - 第二位学生从位置 3 移动到位置 4 ，移动 1 次。
 * - 第三位学生从位置 2 移动到位置 5 ，移动 3 次。
 * - 第四位学生从位置 6 移动到位置 9 ，移动 3 次。
 * 总共 0 + 1 + 3 + 3 = 7 次移动。
 * 示例 3：
 * <p>
 * 输入：seats = [2,2,6,6], students = [1,3,2,6]
 * 输出：4
 * 解释：学生移动方式如下：
 * - 第一位学生从位置 1 移动到位置 2 ，移动 1 次。
 * - 第二位学生从位置 3 移动到位置 6 ，移动 3 次。
 * - 第三位学生不移动。
 * - 第四位学生不移动。
 * 总共 1 + 3 + 0 + 0 = 4 次移动。
 */
public class Solution2073 {
    public static void main(String[] args) {
        int[] seats = new int[]{2, 2, 6, 6};
        int[] students = new int[]{1, 3, 2, 6};
        System.out.println(new Solution2073().minMovesToSeat(seats, students));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int rs = 0;
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            rs += Math.abs(seats[i] - students[i]);
        }

        return rs;
    }
}
