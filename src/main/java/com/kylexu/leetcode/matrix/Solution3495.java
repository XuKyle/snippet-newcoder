package com.kylexu.leetcode.matrix;

public class Solution3495 {
    private long get(int num) {
        long cnt = 0;
        int i = 1;
        int base = 1;
        while (base <= num) {
            int end = Math.min(base * 2 - 1, num);
            cnt += (long) ((i + 1) / 2) * (end - base + 1);
            i++;
            base *= 2;
        }
        return cnt;
    }

    public long minOperations(int[][] queries) {
        long res = 0;
        for (int[] q : queries) {
            long count1 = get(q[1]);
            long count2 = get(q[0] - 1);
            res += (count1 - count2 + 1) / 2;
        }
        return res;
    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/minimum-operations-to-make-array-elements-zero/solutions/3764859/shi-shu-zu-yuan-su-du-bian-wei-ling-de-z-11m3/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
