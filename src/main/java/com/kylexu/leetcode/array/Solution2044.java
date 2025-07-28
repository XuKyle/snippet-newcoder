package com.kylexu.leetcode.array;

public class Solution2044 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int i = new Solution2044().countMaxOrSubsets(nums);
        System.out.println("i = " + i);
    }

    public int countMaxOrSubsets(int[] nums) {
        //从0-1<<nums.length这些数挨个枚举，数字i的二进制数位表示是否选择原数组对应位置的元素
        int maxoR = 0, res = 0;
        for (int i = 0; i < 1 << nums.length; i++) {
            int or = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {//取数字i的数位，如果当前数位为1，说明这个子集取第j个元素
                    or |= nums[j];
                }
            }
            if (or > maxoR) {
                maxoR = or;
                res = 1;
            } else if (or == maxoR) {
                res++;
            }
            //否则就是小于maxOr，这个或的和可以舍弃
        }
        return res;
    }
}
