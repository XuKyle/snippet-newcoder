package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * 示例 1：
 * <p>
 * 输入： nums = [0,1,1,0]
 * <p>
 * 输出： [0,1]
 * <p>
 * 解释：
 * <p>
 * 数字 0 和 1 分别在数组中出现了两次。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [0,3,2,1,3,2]
 * <p>
 * 输出： [2,3]
 * <p>
 * 解释:
 * <p>
 * 数字 2 和 3 分别在数组中出现了两次。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [7,1,5,4,3,4,6,0,9,5,8,2]
 * <p>
 * 输出： [4,5]
 * <p>
 * 解释:
 * <p>
 * 数字 4 和 5 分别在数组中出现了两次。
 */
public class Solution3289 {
    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 1, 3, 2};
        int[] sneakyNumbers = new Solution3289().getSneakyNumbers(nums);
        System.out.println("sneakyNumbers = " + Arrays.toString(sneakyNumbers));
    }

    public int[] getSneakyNumbers(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(pre -> pre.getValue() > 1)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
