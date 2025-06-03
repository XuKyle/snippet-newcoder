package com.kylexu.leetcode.design;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果满足以下条件，那么箱子是 "Bulky" 的：
 * 箱子 至少有一个 维度大于等于 104 。
 * 或者箱子的 体积 大于等于 109 。
 * 如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
 * 如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
 * 如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
 * 如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
 * 如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
 * 注意，箱子的体积等于箱子的长度、宽度和高度的乘积。
 */
public class Solution2525 {
    public static void main(String[] args) {
        int length = 2909, width = 3968, height = 3272, mass = 300;
        String rs = new Solution2525().categorizeBox(length, width, height, mass);
        System.out.println("rs = " + rs);
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        Set<String> category = new HashSet<>();
        long volume = (long) length * width * height;

        if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= Math.pow(10, 9)) {
            category.add("Bulky");
        }

        if (mass >= 100) {
            category.add("Heavy");
        }

        if (category.contains("Bulky") && category.contains("Heavy")) {
            return "Both";
        } else if (category.contains("Bulky")) {
            return "Bulky";
        } else if (category.contains("Heavy")) {
            return "Heavy";
        }
        return "Neither";
    }
}
