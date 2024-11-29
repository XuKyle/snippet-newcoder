package com.kylexu.leetcode.num;

/**
 * 社团共有 num 位成员参与破冰游戏，
 * 编号为 0 ~ num-1。成员们按照编号顺序围绕圆桌而坐。
 * 社长抽取一个数字 target，从 0 号成员起开始计数，排在第 target 位的成员离开圆桌，且成员离开后
 * 从下一个成员开始计数。请返回游戏结束时最后一位成员的编号。
 * <p>
 * <p>
 * 示例 1：
 * 输入：num = 7, target = 4
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：num = 12, target = 5
 * 输出：0
 */
public class LCRSolution87 {
    public static void main(String[] args) {
        System.out.println(new LCRSolution87().iceBreakingGame(7, 4));
    }

    public int iceBreakingGame(int num, int target) {
        /**
         * 思路：使用数学方法(先举例) 你要知道最后的结果是3，带着结果去看问题
         *
         *         第一次，【0, 1, 2, 3, 4】，本轮要踢出2                                  看3
         *         (下一轮开始从3计数，为了方便读者看出规律，将开始计数的那一位移到开头)
         *         第二次，【3, 4, 0, 1】，本轮要踢出0                                     看1
         *         第三次，【1, 3, 4】，本轮要踢出4                                        看1
         *         第四次，【1, 3】 本轮要踢出1                                            看3
         *         第五次，【3】
         *         最后返回3
         *
         *         我们要使用的数学方法，就是从结果0号位置，反推最开始在哪
         *         你从第二次，向上看第一次
         *         你会发现，原来3在0的位置
         *                 现在，3在(0 + 3) % 5
         *                         => +3 回到上次的位置
         *                         => %5 防止数组溢出，并且数组本来就是循环数组
         *
         *         f(n) = ( f(n - 1) + m ) % n
         *         解释意思：
         *             f(n) 表示上一次
         *             f(n - 1) 表示这次，因为我们要从这次回推上一次
         *             m 表示隔几个
         *             n表示上一次的数组长度
         */
        int res = 0;
        for (int i = 2; i <= num; i++) {
            res = (res + target) % i;
        }

        return res;
    }
}
