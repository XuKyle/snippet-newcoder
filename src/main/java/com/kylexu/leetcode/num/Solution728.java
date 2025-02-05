package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 示例 2:
 * <p>
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 */
public class Solution728 {

    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        Solution728 solution728 = new Solution728();
        List<Integer> integerList = solution728.selfDividingNumbers(left, right);
        System.out.println("integerList = " + integerList);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> rs = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (check(i)) {
                rs.add(i);
            }
        }

        return rs;
    }

    public boolean check(int num) {
        int bak = num;
        if (num < 10) {
            return true;
        }

        while (num != 0) {
            int left = num % 10;
            if (left == 0) {
                return false;
            }
            if (bak % left != 0) {
                return false;
            }
            num = num / 10;
        }

        return true;
    }
}
