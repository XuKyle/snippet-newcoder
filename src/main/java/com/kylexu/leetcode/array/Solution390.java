package com.kylexu.leetcode.array;

/**
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * <p>
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 */
public class Solution390 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(new Solution390().lastRemaining(n));
    }


    public int lastRemaining(int n) {
//        假如输入为 n，我们使用 f(n) 表示 从左到右(forward) 的最终结果，使用 b(n)表示 从右到左(backward) 的最终结果。则：
//
//        当 n = 1 时，存在 f(n) = 1, b(n) = 1
//        对于任意 n，存在 f(n) + b(n) = n + 1
//        对于 n > 2 的情况下，f(n) = 2 * b(n / 2)
//        所以：f(n) = 2 * (n / 2 + 1 - f(n / 2))

        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

//    输入：n = 9
//    输出：6
//    解释：
//    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//    arr = [2, 4, 6, 8]
//    arr = [2, 6]
//    arr = [6]

}
