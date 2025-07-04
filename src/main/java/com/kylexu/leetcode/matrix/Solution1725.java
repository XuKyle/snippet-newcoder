package com.kylexu.leetcode.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution1725 {
    public static void main(String[] args) {
        int[][] rectangles = {
                {5, 8},
                {3, 9},
                {3, 12},
//                {16, 5}

        };

//        5,8],[3,9],[3,12]

        int i = new Solution1725().countGoodRectangles(rectangles);
        System.out.println("i = " + i);
    }

    public int countGoodRectangles(int[][] rectangles) {

        return Arrays.stream(rectangles)
                .mapToInt(rec -> Math.min(rec[0], rec[1]))
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ),
                        map -> map.entrySet().stream()
                                .max(Map.Entry.comparingByKey())
                                .map(entry -> entry.getValue().intValue())
                                .get()
                ));

//        return Arrays.stream(rectangles)
//                .map(rec -> Math.min(rec[0], rec[1]))
//                .mapToInt(Integer::intValue)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .sorted((a, b) -> {
//                    return Long.compare(b.getValue(), a.getValue());
//                })
//                .limit(1)
//                .map(Map.Entry::getKey)
//                .findFirst()
//                .get();
    }
}
