package com.kylexu.leetcode.daily.m202508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> last = Arrays.asList(1);
        List<List<Integer>> rs = new ArrayList<>();

        rs.add(last);

        for (int i = 1; i < numRows; i++) {
            List<Integer> integers = rs.get(i - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);

            for (int j = 0; j < integers.size() - 1; j++) {
                current.add(integers.get(j) + integers.get(j + 1));
            }

            current.add(1);
            rs.add(current);
        }

        return rs;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> generate = new Solution118().generate(numRows);
        for (List<Integer> integers : generate) {
            System.out.println("integers = " + integers);
        }
    }
}
