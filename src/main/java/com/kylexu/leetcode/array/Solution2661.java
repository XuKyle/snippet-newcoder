package com.kylexu.leetcode.array;

/**
 * 给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
 * 保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
 * 假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
 * <p>
 * 如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
 * 否则，为 xi 。
 * 玩家的得分是其 n 轮价值的总和。
 * <p>
 * 返回
 * <p>
 * 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
 * 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
 * 如果平局，则为 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：player1 = [5,10,3,2], player2 = [6,5,7,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 玩家 1 的分数为 5 + 10 + 2*3 + 2*2 = 25。
 * <p>
 * 玩家 2 的分数为 6 + 5 + 7 + 3 = 21。
 * <p>
 * 示例 2：
 * <p>
 * 输入：player1 = [3,5,7,6], player2 = [8,10,10,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 玩家 1 的分数为 3 + 5 + 7 + 6 = 21。
 * <p>
 * 玩家 2 的分数为 8 + 10 + 2*10 + 2*2 = 42。
 * <p>
 * 示例 3：
 * <p>
 * 输入：player1 = [2,3], player2 = [4,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 玩家 1 的分数为 2 + 3 = 5。
 * <p>
 * 玩家 2 的分数为 4 + 1 = 5。
 * <p>
 * 示例 4：
 * <p>
 * 输入：player1 = [1,1,1,10,10,10,10], player2 = [10,10,10,10,1,1,1]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 玩家 1 的分数为 1 + 1 + 1 + 10 + 2*10 + 2*10 + 2*10 = 73。
 * <p>
 * 玩家 2 的分数为 is 10 + 2*10 + 2*10 + 2*10 + 2*1 + 2*1 + 1 = 75。
 */
public class Solution2661 {
    public static void main(String[] args) {
        int[] player1 = new int[]{1, 1, 1, 10, 10, 10, 10};
        int[] player2 = new int[]{10, 10, 10, 10, 1, 1, 1};
        System.out.println(new Solution2661().isWinner(player1, player2));
    }

    public int isWinner(int[] player1, int[] player2) {
        int scorePlayer1 = score(player1);
        int scorePlayer2 = score(player2);

        if (scorePlayer1 == scorePlayer2) {
            return 0;
        } else if (scorePlayer1 > scorePlayer2) {
            return 1;
        }
        return 2;
    }

    public int score(int[] nums) {
        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean flag = false;
            if (i == 1) {
                flag = nums[i - 1] == 10;
            } else if (i >= 2) {
                flag = nums[i - 1] == 10 || nums[i - 2] == 10;
            }
            if (flag) {
                rs += 2 * num;
            } else {
                rs += num;
            }
        }
        return rs;
    }
}
