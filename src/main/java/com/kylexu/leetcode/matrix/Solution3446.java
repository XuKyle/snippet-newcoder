package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3446 {
    public static void main(String[] args) {

    }

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; i + j < n; j++) {
                tmp.add(grid[i + j][j]);
            }
            tmp.sort(Collections.reverseOrder());
            for (int j = 0; i + j < n; j++) {
                grid[i + j][j] = tmp.get(j);
            }
        }

        for (int j = 1; j < n; j++) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; j + i < n; i++) {
                tmp.add(grid[i][j + i]);
            }
            Collections.sort(tmp);
            for (int i = 0; j + i < n; i++) {
                grid[i][j + i] = tmp.get(i);
            }
        }

        return grid;
//
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/sort-matrix-by-diagonals/solutions/3756283/an-dui-jiao-xian-jin-xing-ju-zhen-pai-xu-86ki/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
