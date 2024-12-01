package com.kylexu.leetcode.array;


import java.util.Arrays;

/**
 * 展览馆展出来自 13 个朝代的文物，每排展柜展出 5 个文物。某排文物的摆放情况记录于数组 places，其中 places[i] 表示处于第 i 位文物的所属朝代编号。其中，编号为 0 的朝代表示未知朝代。请判断并返回这排文物的所属朝代编号是否能够视为连续的五个朝代（如遇未知朝代可算作连续情况）。
 * 示例 1：
 * <p>
 * 输入: places = [0, 6, 9, 0, 7]
 * 输出: True
 * 示例 2：
 * <p>
 * 输入: places = [7, 8, 9, 10, 11]
 * 输出: True
 */
public class LCRSolution186 {
    public static void main(String[] args) {
        int[] places = new int[]{0, 6, 9, 0, 7};
        System.out.println(new LCRSolution186().checkDynasty(places));
    }

    public boolean checkDynasty(int[] places) {
        Arrays.sort(places);

        int zeroCnt = 0;
        int gap = 0;

        if (places[0] == 0) {
            zeroCnt++;
        }

        for (int i = 1; i < places.length; i++) {
            if (places[i] == 0) {
                zeroCnt++;
            } else if (places[i - 1] == 0) {
                continue;
            } else if (places[i - 1] == places[i]) {
                return false;
            } else {
                gap += Math.abs(places[i] - places[i - 1]) - 1;
            }
        }

        return zeroCnt >= gap;
    }
}
