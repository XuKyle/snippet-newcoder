package leetcode.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] rs = new Solution239().maxSlidingWindow(nums, k);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] rs = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            int current = nums[i];
            while (!queue.isEmpty() && queue.peekLast() < current) {
                queue.removeLast();
            }
            queue.add(current);
        }
        rs[0] = queue.peekFirst();

        for (int i = k; i < n; i++) {
            int leftNumber = nums[i - k];
            Integer first = queue.peekFirst();
            if (leftNumber == first) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.add(nums[i]);

            rs[i - k + 1] = queue.peekFirst();
        }

        return rs;
    }
}
