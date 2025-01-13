package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2418 {
    public static void main(String[] args) {
//        names = ["Mary","John","Emma"], heights = [180,165,170]
        String[] names = new String[]{"Mary", "John", "Emma"};
        int[] heights = new int[]{180, 165, 170};
        String[] sorted = new Solution2418().sortPeople(names, heights);
        System.out.println("sorted = " + Arrays.toString(sorted));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        return IntStream.range(0, names.length)
                .boxed()
                .collect(Collectors.toMap(i -> heights[i], i -> names[i]))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(Map.Entry::getValue)
                .toArray(String[]::new);
    }
}
