package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            while (!ans.isEmpty()) {
                int last = ans.get(ans.size() - 1);
                int g = gcd(last, num);
                if (g > 1) {
                    num = last / g * num;
                    ans.remove(ans.size() - 1);
                } else {
                    break;
                }
            }
            ans.add(num);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/replace-non-coprime-numbers-in-array/solutions/1328577/ti-huan-shu-zu-zhong-de-fei-hu-zhi-shu-b-mnml/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
