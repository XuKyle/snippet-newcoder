package com.kylexu.leetcode.other;

import java.util.Arrays;

/**
 * 输入：edges = [[1,2],[2,3],[4,2]]
 * 输出：2
 * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 * 示例 2：
 * <p>
 * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出：1
 */
public class Solution1791 {
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {5, 1},
                {1, 3},
                {1, 4},
        };

        int center = new Solution1791().findCenter(edges);
        System.out.println("center = " + center);
    }

    public int findCenter(int[][] edges) {
        boolean flag = true;

        int current = edges[0][0];
        for (int[] edge : edges) {
            boolean f = false;
            for (int i : edge) {
                if (i == current) {
                    f = true;
                    break;
                }
            }

            if (!f) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return current;
        }
        return edges[0][1];
    }
}
