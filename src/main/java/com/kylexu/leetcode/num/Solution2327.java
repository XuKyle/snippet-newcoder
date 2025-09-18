package com.kylexu.leetcode.num;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2327 {
    private static final int MOD = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Deque<int[]> know = new LinkedList<>();
        Deque<int[]> share = new LinkedList<>();
        know.add(new int[]{1, 1});
        int knowCnt = 1, shareCnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!know.isEmpty() && know.peekFirst()[0] == i - delay) {
                int[] first = know.pollFirst();
                knowCnt = (knowCnt - first[1] + MOD) % MOD;
                shareCnt = (shareCnt + first[1]) % MOD;
                share.add(first);
            }
            if (!share.isEmpty() && share.peekFirst()[0] == i - forget) {
                int[] first = share.pollFirst();
                shareCnt = (shareCnt - first[1] + MOD) % MOD;
            }
            if (!share.isEmpty()) {
                knowCnt = (knowCnt + shareCnt) % MOD;
                know.add(new int[]{i, shareCnt});
            }
        }
        return (knowCnt + shareCnt) % MOD;
    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/number-of-people-aware-of-a-secret/solutions/3771803/er-de-mi-shu-zu-zhong-cha-xun-fan-wei-ne-kbs4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {

    }
}
