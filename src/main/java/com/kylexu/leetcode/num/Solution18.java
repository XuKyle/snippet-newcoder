package leetcode.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class Solution18 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> rs = new Solution18().fourSum(nums, target);
        System.out.println("rs = " + rs);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int first = 0; first < n; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            for (int second = first + 1; second < n; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                long left = (long) target - add(nums[first], nums[second]);
                int four = n - 1;
                for (int third = second + 1; third < n; third++) {
                    if (third != second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }

                    while (four > third && add(nums[third], nums[four]) > left) {
                        four--;
                    }

                    if (four == third) {
                        break;
                    }

                    if (add(nums[third], nums[four]) == left) {
                        rs.add(List.of(nums[first], nums[second], nums[third], nums[four]));
                    }
                }
            }
        }

        return rs;
    }

    private Long add(Integer a, Integer b) {
        return (long) a + (long) b;
    }
}
