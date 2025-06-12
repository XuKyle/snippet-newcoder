package com.kylexu.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 */
public class Solution376 {
    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int rs = new Solution376().wiggleMaxLength(nums);
        System.out.println("rs = " + rs);
    }

    public int wiggleMaxLength(int[] nums) {
        List<Integer> gap = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            gap.add(nums[i + 1] - nums[i]);
        }
        System.out.println("gap = " + gap);

        return 0;
    }
}
