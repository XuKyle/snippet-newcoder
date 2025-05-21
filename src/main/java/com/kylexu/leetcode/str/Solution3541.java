package com.kylexu.leetcode.str;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution3541 {
    public static void main(String[] args) {
        String s = "successes";
        int rs = new Solution3541().maxFreqSum(s);
        System.out.println("rs = " + rs);
    }

    public int maxFreqSum(String s) {
//        Set<Character> ch = Set.of('a', 'e', 'i', 'o', 'u');
//
//        Map<Boolean, List<Map.Entry<Character, Long>>> collect = s.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .collect(Collectors.partitioningBy(entry -> ch.contains(entry.getKey())));
//
//        Long a = collect.get(true).stream().map(Map.Entry::getValue).max(Long::compare).orElse(0L);
//        Long b = collect.get(false).stream().map(Map.Entry::getValue).max(Long::compare).orElse(0L);
//
//        return a.intValue() + b.intValue();


        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        Long collect = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(
                        Collectors.partitioningBy(
                                vowels::contains,
                                Collectors.collectingAndThen(
                                        Collectors.groupingBy(Function.identity(), Collectors.counting()),
                                        m -> m.values().stream().max(Long::compare).orElse(0L)
                                )
                        ),
                        map -> map.get(true) + map.get(false)
                ));

        return collect.intValue();
    }
}
