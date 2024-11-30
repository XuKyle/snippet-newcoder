package com.kylexu.leetcode.num;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class Solution50 {
    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2, -2));
    }

    public double myPow(double x, int n) {
//        if (x == 1 || x == 0) {
//            return x;
//        }
//
//        if (n < 0) {
//            x = 1 / x;
//            n = -1 * n;
//        }
//
//        double sum = 1;
//        for (int i = 0; i < n; i++) {
//            sum *= x;
//        }
//        return sum;


        //首先，要求幂函数
        //于是，定义一个变量为1
        double ans = 1;
        //这里使用64位的int，预防n值小于0时，发生越界异常
        //赋值给m变量
        long m = n;
        //判断m的值是正是负
        //如果是负数，做出调整
        if (m < 0) {
            m = -m;
            x = 1 / x;
        }
        //判断m的值是否为0
        while (m != 0) {
            //通过位运算，用逻辑与运算符判断m的最低位是否是1
            //这里会将整数m隐式的转换为二进制数，并对最低为进行判断
            if ((m & 1) == 1) {
                //如果最低位为1，则乘x
                ans *= x;
            }
            //这里是快速幂的格式
            x *= x;
            //通过右移赋值运算符，舍弃最低位
            m >>= 1;
        }
        return ans;
    }
}
