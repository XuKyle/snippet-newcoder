package com.kylexu.leetcode.array;

public class Solution2717 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5};
        int rs = new Solution2717().semiOrderedPermutation(nums);
        System.out.println("rs = " + rs);
    }

    public int semiOrderedPermutation(int[] nums) {
        int indexOne = -1;
        int indexN = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                indexOne = i;
            }

            if (nums[i] == nums.length) {
                indexN = i;
            }
        }

//        System.out.println("indexOne = " + indexOne);
//        System.out.println("indexN = " + indexN);

        if (indexOne > indexN) {
            return indexOne + nums.length - 1 - indexN - 1;
        } else {
            return indexOne + nums.length - 1 - indexN;
        }
    }
}
