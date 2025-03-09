package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.List;

public class Solution830 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Solution830().largeGroupPositions(s));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<Pair> rs = new ArrayList<>();

        int start = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(start) != s.charAt(i)) {
                Pair pair = new Pair(start, i - 1, s.charAt(start));
                rs.add(pair);
                start = i;
            } else {
                if (i == n - 1) {
                    Pair pair = new Pair(start, i, s.charAt(start));
                    rs.add(pair);
                    start = i;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Pair r : rs) {
            if (r.bigGroup()) {
                result.add(r.getStartEndIndex());
            }
        }

        return result;
    }

    class Pair {
        int start;
        int end;
        Character str;

        public Pair(int start, int end, Character str) {
            this.start = start;
            this.end = end;
            this.str = str;
        }

        public int getLength() {
            return end - start + 1;
        }

        public boolean bigGroup() {
            return getLength() >= 3;
        }

        public List<Integer> getStartEndIndex() {
            return List.of(start, end);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    ", str=" + str +
                    '}';
        }
    }
}
