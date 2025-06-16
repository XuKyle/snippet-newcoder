package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.List;

public class Solution2194 {
    public static void main(String[] args) {
//        输入：s = "K1:L2"
//        输出：["K1","K2","L1","L2"]
        String s = "A1:F1";
        List<String> strings = new Solution2194().cellsInRange(s);
        System.out.println("strings = " + strings);
    }

    public List<String> cellsInRange(String s) {
        String[] split = s.split(":");
        int startCol = split[0].charAt(0) - 'A';
        int startRow = split[0].charAt(1) - '0';

        int endCol = split[1].charAt(0) - 'A';
        int endRow = split[1].charAt(1) - '0';

        List<String> rs = new ArrayList<>();

        for (int j = startCol; j <= endCol; j++) {
            for (int i = startRow; i <= endRow; i++) {
                String s1 = Character.toString('A' + j) + i;
                rs.add(s1);
            }
        }

        return rs;
    }
}
