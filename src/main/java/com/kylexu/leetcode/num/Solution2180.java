package com.kylexu.leetcode.num;

public class Solution2180 {
    public static void main(String[] args) {
        int num = 30;
        System.out.println(new Solution2180().countEven(num));
    }

    public int countEven(int num) {
        int rs = 0;
        for (int i = 1; i <= num; i++) {
            if (sum(i)) {
                rs++;
            }
        }
        return rs;
    }

    private boolean sum(int i) {
        int rs = 0;
        while (i != 0) {
            rs += i % 10;
            i = i / 10;
        }
        return rs % 2 == 0;
    }
}
