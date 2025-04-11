package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class Solution228 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> rs = new Solution228().summaryRanges(nums);
        System.out.println("rs = " + rs);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length <= 1) {
            return Arrays.stream(nums).mapToObj(String::valueOf).toList();
        }

        List<String> rs = new ArrayList<>();

        int start = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (start == i) {
                    rs.add(nums[start] + "");
                } else {
                    rs.add(nums[start] + "->" + nums[i]);
                }
                start = i + 1;
            }

            // 处理最后一个元素
            if (i == nums.length - 2) {
                if (nums[i] + 1 != nums[i + 1]) {
                    rs.add(nums[i + 1] + "");
                } else {
                    rs.add(nums[start] + "->" + nums[i + 1]);
                }
            }
        }

        return rs;
    }
}
