package com.kylexu.leetcode.num;

/**
 * n 个人站成一排，按从 1 到 n 编号。最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。
 * <p>
 * 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
 * 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, time = 5
 * 输出：2
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 -> 4 -> 3 -> 2 。
 * 5 秒后，枕头传递到第 2 个人手中。
 * 示例 2：
 * <p>
 * 输入：n = 3, time = 2
 * 输出：3
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 。
 * 2 秒后，枕头传递到第 3 个人手中。
 */
public class Solution2582 {
    public static void main(String[] args) {
        int n = 3, time = 2;
        int rs = new Solution2582().passThePillow(n, time);
        System.out.println("rs = " + rs);
    }

    public int passThePillow(int n, int time) {
        int rs = 1;
        boolean forward = true;
        while (time > 0) {
            if (rs == n) {
                forward = false;
            } else if (rs == 1) {
                forward = true;
            }
            if (forward) {
                rs++;
            } else {
                rs--;
            }
            time--;
        }

        return rs;
    }
}
