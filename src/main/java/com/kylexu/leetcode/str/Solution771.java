package com.kylexu.leetcode.str;

/**
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * 示例 1：
 * <p>
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 */
public class Solution771 {
    public static void main(String[] args) {
        var jewels = "aA";
        var stones = "aAAbbbb";
        System.out.println(new Solution771().numJewelsInStones(jewels, stones));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int rs = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.contains(Character.toString(c))) {
                rs++;
            }
        }
        return rs;
    }
}
