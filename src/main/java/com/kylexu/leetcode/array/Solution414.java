package com.kylexu.leetcode.array;

import java.util.TreeSet;

/**
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 */
public class Solution414 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(new Solution414().thirdMax(nums));
    }


    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }

        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }
}
