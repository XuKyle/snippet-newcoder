package com.kylexu.leetcode.company.jd;

import java.util.Map;
import java.util.TreeMap;

/**
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class Solution215 {
    public static void main(String[] args) {
        int[] rs = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Solution215().findKthLargest(rs, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count < k) {
                count += entry.getValue();
            }

            if (count >= k) {
                return entry.getKey();
            }
        }

        return 1;
    }

//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }
}
