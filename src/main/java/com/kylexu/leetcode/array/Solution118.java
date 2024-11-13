package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 */
public class Solution118 {
    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution118().generate(10);
        System.out.println("generate = " + generate);
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> inner = new ArrayList<>();
            if (i == 1) {
                inner.add(i);
            } else {
                List<Integer> lastLine = rs.get(i - 1 - 1);

                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        inner.add(1);
                    } else {
                        inner.add(lastLine.get(j - 1) + lastLine.get(j));
                    }
                }
            }
            rs.add(inner);
        }

        return rs;
    }
}
