package com.kylexu.leetcode.str;

import java.util.*;

public class Solution2785 {
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
    ));

    public String sortVowels(String s) {
        List<Character> tmp = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                tmp.add(ch);
            }
        }

        Collections.sort(tmp);

        char[] arr = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (vowels.contains(arr[i])) {
                arr[i] = tmp.get(idx++);
            }
        }

        return new String(arr);

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/sort-vowels-in-a-string/solutions/3766881/jiang-zi-fu-chuan-zhong-de-yuan-yin-zi-m-qllf/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
