package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution3158 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3};
        int i = new Solution3158().duplicateNumbersXOR(nums);
        System.out.println("i = " + i);
    }

    public int duplicateNumbersXOR(int[] nums) {

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .mapToInt(Map.Entry::getKey)
                .reduce(0, (a, b) -> a ^ b);
    }
}
