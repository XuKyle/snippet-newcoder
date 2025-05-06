package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：height = [1,2,3,4,5], threshold = 2
 * <p>
 * 输出：[3,4]
 */
public class Solution3285 {
    public static void main(String[] args) {
        int[] height = {1, 2, 3, 4, 5};
        int threshold = 2;
        List<Integer> rs = new Solution3285().stableMountains(height, threshold);
        System.out.println("rs = " + rs);
    }

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> rs = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                rs.add(i);
            }
        }
        return rs;
    }
}
