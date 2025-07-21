package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1233 {
    public static void main(String[] args) {
//        folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
        String[] floder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> rs = new Solution1233().removeSubfolders(floder);
        System.out.println("rs = " + rs);
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> rs = new ArrayList<>(Arrays.stream(folder).toList());

        for (int i = 0; i < rs.size(); i++) {
            for (int j = rs.size() - 1; j > i; j--) {
                if (rs.get(j).startsWith(rs.get(i) + "/")) {
                    rs.remove(j);
                }
            }
        }

        return rs;
    }
}
