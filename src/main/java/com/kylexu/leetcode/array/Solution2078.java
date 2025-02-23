package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution2078 {
    public static void main(String[] args) {
        int[] colors = new int[]{0, 1};
        System.out.println(new Solution2078().maxDistance(colors));
    }

//    输入：colors = [1,8,3,8,3]  =>  4
    //     输入：colors = [1,1,1,6,1,1,1]
//        输出：3

    static class Pair {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        public void addIndex(int index) {
            this.low = Math.min(this.low, index);
            this.high = Math.max(this.high, index);
        }
    }

    public int maxDistance(int[] colors) {
        Map<Integer, Pair> mark = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            mark.computeIfAbsent(colors[i], k -> new Pair()).addIndex(i);
        }

        int rs = 0;
        ArrayList<Map.Entry<Integer, Pair>> list = new ArrayList<>(mark.entrySet());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Pair left = list.get(i).getValue();
                Pair right = list.get(j).getValue();
                int gap = Math.max(Math.abs(left.low - right.high), Math.abs(left.high - right.low));
                rs = Math.max(gap, rs);
            }
        }
        return rs;
    }
}
