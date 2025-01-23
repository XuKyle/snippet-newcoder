package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 示例 1：
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,2,3,3,3]
 * 输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [2,2,2,3,3]
 * 输出：-1
 * 解释：数组中不存在幸运数。
 * 示例 4：
 * <p>
 * 输入：arr = [5]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：arr = [7,7,7,7,7,7,7]
 * 输出：7
 */
public class Solution1394 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 3};
        System.out.println(new Solution1394().findLucky(arr));
    }

    public int findLucky(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i : arr) {
            counter.merge(i, 1, Integer::sum);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (Objects.equals(entry.getKey(), entry.getValue())) {
                max = Math.max(max, entry.getValue());
            }
        }

        return max;
    }
}
