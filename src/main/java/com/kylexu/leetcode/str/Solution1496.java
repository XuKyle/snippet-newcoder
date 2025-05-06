package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution1496 {
    public static void main(String[] args) {
        String path = "SS";
        boolean pathCrossing = new Solution1496().isPathCrossing(path);
        System.out.println("pathCrossing = " + pathCrossing);
    }

    public boolean isPathCrossing(String path) {
        List<Pair> route = new ArrayList<>();

        Pair pair = new Pair(0, 0);
        route.add(pair);

        for (int i = 0; i < path.length(); i++) {
            Pair next = pair.next(path.charAt(i));
            if (route.contains(next)) {
                return true;
            }
            route.add(next);
            pair = next;
        }
        return false;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair next(Character c) {
//            'N'、'S'、'E' 或者 'W'
            if (c == 'N') {
                return new Pair(this.x, this.y + 1);
            }
            if (c == 'S') {
                return new Pair(this.x, this.y - 1);
            }
            if (c == 'E') {
                return new Pair(this.x + 1, this.y);
            }

            if (c == 'W') {
                return new Pair(this.x - 1, this.y);
            }
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
