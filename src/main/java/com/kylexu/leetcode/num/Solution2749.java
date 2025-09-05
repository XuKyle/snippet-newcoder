package com.kylexu.leetcode.num;

public class Solution2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long k = 1; k <= num1 - num2 * k; k++) {
            if (k >= Long.bitCount(num1 - num2 * k)) {
                return (int) k;
            }
        }
        return -1;

//        作者：灵茶山艾府
//        链接：https://leetcode.cn/problems/minimum-operations-to-make-the-integer-zero/solutions/2319632/mei-ju-da-an-pythonjavacgo-by-endlessche-t4co/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
