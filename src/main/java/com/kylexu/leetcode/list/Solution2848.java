package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 示例 1：
 * 输入：nums = [[3,6],[1,5],[4,7]]
 * 输出：7
 * 解释：从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,3],[5,8]]
 * 输出：7
 * 解释：1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
 */
public class Solution2848 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(3, 6));
        nums.add(List.of(1, 5));
        nums.add(List.of(4, 7));
        System.out.println(new Solution2848().numberOfPoints(nums));
    }

    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> mark = new HashSet<>();
        for (List<Integer> num : nums) {
            Integer start = num.get(0);
            Integer end = num.get(1);

            IntStream.range(start, end + 1)
                    .boxed()
                    .forEach(mark::add);
        }

        return mark.size();
    }
}
