package com.kylexu.leetcode.array;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 示例 1：
 * <p>
 * 输入： s = "abc", k = 2
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * s 有三个不同的字符：'a'、'b' 和 'c'，每个字符的出现频率为 1。
 * 由于最多只能有 k = 2 个不同字符，需要删除某一个字符的所有出现。
 * 例如，删除所有 'c' 后，结果字符串中的不同字符数最多为 k。因此，答案是 1。
 * 示例 2：
 * <p>
 * 输入： s = "aabb", k = 2
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * s 有两个不同的字符（'a' 和 'b'），它们的出现频率分别为 2 和 2。
 * 由于最多可以有 k = 2 个不同字符，不需要删除任何字符。因此，答案是 0。
 * 示例 3：
 * <p>
 * 输入： s = "yyyzz", k = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * s 有两个不同的字符（'y' 和 'z'），它们的出现频率分别为 3 和 2。
 * 由于最多只能有 k = 1 个不同字符，需要删除某一个字符的所有出现。
 * 删除所有 'z' 后，结果字符串中的不同字符数最多为 k。因此，答案是 2。
 */
public class Solution3545 {
    public static void main(String[] args) {
        var s = "yyyzz";
        var k = 1;

        int rs = new Solution3545().minDeletion(s, k);
        System.out.println("rs = " + rs);
    }

    public int minDeletion(String s, int k) {
//        return s.chars()
//                .mapToObj(Character::toString)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(Map.Entry::getValue).reversed())
//                .skip(k)
//                .map(Map.Entry::getValue)
//                .toList()
//                .stream()
//                .mapToInt(Long::intValue)
//                .sum();


        return (int) s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values().stream()
                .sorted(Comparator.reverseOrder())
                .skip(k)
                .mapToLong(Long::longValue)
                .sum();
    }
}
