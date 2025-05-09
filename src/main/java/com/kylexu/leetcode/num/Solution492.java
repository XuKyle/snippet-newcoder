package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 你设计的矩形页面必须等于给定的目标面积。
 * 宽度 W 不应大于长度 L ，换言之，要求 L >= W 。
 * 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 返回一个 数组 [L, W]，其中 L 和 W 是你按照顺序设计的网页的长度和宽度。
 */
public class Solution492 {
    public static void main(String[] args) {
        int area = 4;
        int[] rs = new Solution492().constructRectangle(area);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    static class Pair {
        int l;
        int w;

        public Pair(int l, int w) {
            this.l = l;
            this.w = w;
        }

        public int gap() {
            return l - w;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "l=" + l +
                    ", w=" + w +
                    '}';
        }
    }

    public int[] constructRectangle(int area) {
        List<Pair> pairList = new ArrayList<>();

        for (int w = 1; w <= area; w++) {
            if (area % w == 0) {
                if (area / w >= w) {
                    pairList.add(new Pair(area / w, w));
                }
            }
        }

        Pair pair = pairList.stream()
                .sorted(Comparator.comparing(Pair::gap))
                .limit(1)
                .findFirst()
                .get();


        return new int[]{pair.l, pair.w};
    }
}
