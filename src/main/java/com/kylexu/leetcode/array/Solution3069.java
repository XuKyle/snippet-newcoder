package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：nums = [5,4,3,8]
 * 输出：[5,3,4,8]
 * 解释：在前两次操作后，arr1 = [5] ，arr2 = [4] 。
 * 在第 3 次操作中，由于 arr1 的最后一个元素大于 arr2 的最后一个元素（5 > 4），将 nums[3] 追加到 arr1 ，因此 arr1 变为 [5,3] 。
 * 在第 4 次操作中，由于 arr2 的最后一个元素大于 arr1 的最后一个元素（4 > 3），将 nums[4] 追加到 arr2 ，因此 arr2 变为 [4,8] 。
 * 4 次操作后，arr1 = [5,3] ，arr2 = [4,8] 。
 * 因此，连接形成的数组 result 是 [5,3,4,8] 。
 */
public class Solution3069 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int[] rs = new Solution3069().resultArray(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] resultArray(int[] nums) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        a1.add(nums[0]);
        a2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (a1.get(a1.size() - 1) > a2.get(a2.size() - 1)) {
                a1.add(nums[i]);
            } else {
                a2.add(nums[i]);
            }
        }
        a1.addAll(a2);

        return a1.stream().mapToInt(Integer::intValue).toArray();
    }
}
