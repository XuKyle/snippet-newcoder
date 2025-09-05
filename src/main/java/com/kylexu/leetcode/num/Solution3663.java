package com.kylexu.leetcode.num;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution3663 {
    public static void main(String[] args) {
        int n = 1553322;
        int leastFrequentDigit = new Solution3663().getLeastFrequentDigit(n);
        System.out.println("leastFrequentDigit = " + leastFrequentDigit);
    }

    public int getLeastFrequentDigit(int n) {
        return String.valueOf(n)
                .chars() // 生成IntStream
                .map(c -> c - '0') // 将字符的ASCII码直接转换为数字值
                .boxed() // 将IntStream装箱为Stream<Integer>，以便后续收集
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue()) // 直接找到最小值
                .map(Map.Entry::getKey) // 如果有最小值，提取对应的键（数字）
                .orElseThrow(); // 如果输入为空字符串等情况可能抛出异常，根据需求处理
    }
}
