package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution3169 {
    public static void main(String[] args) {
        int days = 57;
//        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
//        int[][] meetings = {{2, 4}, {1, 3}};
        int[][] meetings = {{3, 49}, {23, 44}, {21, 56}, {26, 55}, {23, 52}, {2, 9}, {1, 48}, {3, 31}};
//        [5,7],[1,3],[9,10]
        int i = new Solution3169().countDays(days, meetings);
        System.out.println("i = " + i);
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (left, right) -> Integer.compare(left[0], right[0]));
        System.out.println("meetings = " + Arrays.deepToString(meetings));

        LinkedList<int[]> merger = new LinkedList<>();


        for (int[] current : meetings) {
            if (merger.isEmpty()) {
                merger.add(current);
            } else {
                int[] last = merger.peekLast();
                System.out.println("last = " + Arrays.toString(last));
                if (last[1] > current[1]) {
                    continue;
                }
                if (current[0] <= last[1]) {
                    last[1] = current[1];
                } else {
                    merger.addLast(current);
                }
            }
        }
        for (int[] rs : merger) {
            System.out.println("rs = " + Arrays.toString(rs));
        }

        int rs = 0;
        for (int i = 0; i < merger.size(); i++) {
            int[] current = merger.get(i);
            if (i == 0) {
                rs += current[0] - 1;
                System.out.println("rs0 = " + rs);
            }
            if (i == merger.size() - 1) {
                rs += days - current[1];
                System.out.println("rs1 = " + rs);
            } else {
                if (merger.get(i + 1)[0] > current[1] + 1) {
                    rs += merger.get(i + 1)[0] - current[1] - 1;
                }
                System.out.println("rs2 = " + rs);
            }
        }

        return rs;
    }

    public int countDays1(int days, int[][] meetings) {
        int[] dayMark = new int[days + 1];

        for (int[] meeting : meetings) {
            for (int i = meeting[0]; i <= meeting[1]; i++) {
                dayMark[i] = 1;
            }
        }

        int rs = 0;
        for (int i = 1; i < dayMark.length; i++) {
            if (dayMark[i] == 0) {
                rs++;
            }
        }

        return rs;
    }
}
