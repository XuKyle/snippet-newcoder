package com.kylexu.leetcode.array;

/**
 * 输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * 输出：2
 * 解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
 */
public class Solution1779 {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        int rs = new Solution1779().nearestValidPoint(x, y, points);
        System.out.println("rs = " + rs);
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int gap = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int currentGap = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (gap > currentGap) {
                    gap = currentGap;
                    index = i;
                }

            }
        }

        return index;
    }
}
