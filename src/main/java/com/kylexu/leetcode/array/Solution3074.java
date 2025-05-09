package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：apple = [1,3,2], capacity = [4,3,1,5,2]
 * 输出：2
 * 解释：使用容量为 4 和 5 的箱子。
 * 总容量大于或等于苹果的总数，所以可以完成重新分装。
 * 示例 2：
 * <p>
 * 输入：apple = [5,5,5], capacity = [2,4,2,7]
 * 输出：4
 * 解释：需要使用所有箱子。
 */
public class Solution3074 {
    public static void main(String[] args) {
        int[] apple = {5, 5, 5};
        int[] capacity = {2, 4, 2, 7};
        int i = new Solution3074().minimumBoxes(apple, capacity);
        System.out.println("i = " + i);
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }

        int rs = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (capacity[i] + rs >= sum) {
                return capacity.length - i;
            }
            rs += capacity[i];
        }

        return capacity.length;
    }
}
