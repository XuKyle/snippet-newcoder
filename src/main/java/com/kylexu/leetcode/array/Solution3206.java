package com.kylexu.leetcode.array;

public class Solution3206 {
    public int numberOfAlternatingGroups(int[] colors) {
        int rs = 0;

        int n = colors.length;
        for (int i = 0; i < n; i++) {
            int before = ((i + n - 1)) % n;
            int after = (i + 1) % n;
            if (colors[before] != colors[i] && colors[i] != colors[after] && colors[before] == colors[after]) {
                rs++;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
//        输入：colors = [0,1,0,0,1]
        int[] colors = new int[]{0, 1, 0, 0, 1};
        int rs = new Solution3206().numberOfAlternatingGroups(colors);
        System.out.println("rs = " + rs);
    }
}
