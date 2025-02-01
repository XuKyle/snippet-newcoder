package com.kylexu.leetcode.str;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution412 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(new Solution412().fizzBuzz(n));
    }

    public List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(
                        i -> {
                            if (i % 3 == 0 && i % 5 == 0) {
                                return "FizzBuzz";
                            } else if (i % 3 == 0) {
                                return "Fizz";
                            } else if (i % 5 == 0) {
                                return "Buzz";
                            } else {
                                return String.valueOf(i);
                            }
                        }
                ).collect(Collectors.toList());
    }
}
