package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution869 {
    public static void main(String[] args) {
        int n = 10;
        boolean b = new Solution869().reorderedPowerOf2(n);
        System.out.println("b = " + b);
    }

    public boolean reorderedPowerOf2(int n) {
        List<String> mark = new ArrayList<>();

        int num = 1;
        while (num < 1000000000) {
            char[] charArray = String.valueOf(num).toCharArray();
            Arrays.sort(charArray);
            mark.add(new String(charArray));
            num *= 2;
        }

        char[] charArray = String.valueOf(n).toCharArray();
        Arrays.sort(charArray);

        return mark.contains(new String(charArray));
    }
}
