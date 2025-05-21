package com.kylexu.leetcode.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,5,4,2], k = 2
 * 输出：4
 * 解释：4 次操作后，集合中的元素依次添加了 2 ，4 ，5 和 1 。此时集合中包含元素 1 和 2 ，所以答案为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,5,4,2], k = 5
 * 输出：5
 * 解释：5 次操作后，集合中的元素依次添加了 2 ，4 ，5 ，1 和 3 。此时集合中包含元素 1 到 5 ，所以答案为 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,5,3,1], k = 3
 * 输出：4
 * 解释：4 次操作后，集合中的元素依次添加了 1 ，3 ，5 和 2 。此时集合中包含元素 1 到 3  ，所以答案为 4 。
 */
public class Solution2869 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 1, 5, 4, 2);
        int k = 5;
        int rs = new Solution2869().minOperations(nums, k);
        System.out.println("rs = " + rs);
    }

    public int minOperations(List<Integer> nums, int k) {
        int rs = 0;
        Set<Integer> mark = new HashSet<>();
        for (int i = 0; i < k; i++) {
            mark.add(i + 1);
        }

        int index = nums.size() - 1;
        while (!mark.isEmpty()) {
            Integer current = nums.get(index);
            mark.remove(current);
            index--;
            rs++;
        }

        return rs;
    }
}
