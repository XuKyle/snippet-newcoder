package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * 输入：moves = "L_RL__R"
 * 输出：3
 * 解释：可以到达的距离原点 0 最远的点是 -3 ，移动的序列为 "LLRLLLR" 。
 * 示例 2：
 * <p>
 * 输入：moves = "_R__LL_"
 * 输出：5
 * 解释：可以到达的距离原点 0 最远的点是 -5 ，移动的序列为 "LRLLLLL" 。
 * 示例 3：
 * <p>
 * 输入：moves = "_______"
 * 输出：7
 * 解释：可以到达的距离原点 0 最远的点是 7 ，移动的序列为 "RRRRRRR" 。
 */
public class Solution2833 {
    public static void main(String[] args) {
        String moves = "_______";
        System.out.println(new Solution2833().furthestDistanceFromOrigin(moves));
    }

    public int furthestDistanceFromOrigin(String moves) {
        int lNumber = 0;
        int rNumber = 0;
        int dashNumber = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    lNumber++;
                    break;
                case 'R':
                    rNumber++;
                    break;
                case '_':
                    dashNumber++;
                    break;
            }
        }
        return Math.abs(lNumber - rNumber) + dashNumber;
    }
}
