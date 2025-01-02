package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入：operations = ["--X","X++","X++"]
 * 输出：1
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * --X：X 减 1 ，X =  0 - 1 = -1
 * X++：X 加 1 ，X = -1 + 1 =  0
 * X++：X 加 1 ，X =  0 + 1 =  1
 * <p>
 * 示例 2：
 * 输入：operations = ["++X","++X","X++"]
 * 输出：3
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * ++X：X 加 1 ，X = 0 + 1 = 1
 * ++X：X 加 1 ，X = 1 + 1 = 2
 * X++：X 加 1 ，X = 2 + 1 = 3
 * 示例 3：
 * 输入：operations = ["X++","++X","--X","X--"]
 * 输出：0
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * X++：X 加 1 ，X = 0 + 1 = 1
 * ++X：X 加 1 ，X = 1 + 1 = 2
 * --X：X 减 1 ，X = 2 - 1 = 1
 * X--：X 减 1 ，X = 1 - 1 = 0
 */
public class Solution2011 {
    public static void main(String[] args) {
        String[] operations = new String[]{"++X", "++X", "X++"};
        System.out.println(new Solution2011().finalValueAfterOperations(operations));
    }

    public int finalValueAfterOperations(String[] operations) {
        int rs = 0;

        for (String operation : operations) {
            switch (operation) {
                case "X++":
                    rs++;
                    break;
                case "++X":
                    rs++;
                    break;
                case "--X":
                    rs--;
                    break;
                case "X--":
                    rs--;
                    break;
            }
        }

        return rs;
    }
}
