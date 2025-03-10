package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1:
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 */
public class Solution119 {
    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> rs = new ArrayList<>();
        rs.add(1);

        for (int i = 0; i < rowIndex; i++) {
            rs.add(1);

            int n = i + 1;
            for (int j = n - 1; j > 0; j--) {
                rs.set(j, rs.get(j) + rs.get(j - 1));
            }
        }

        return rs;
    }

}
