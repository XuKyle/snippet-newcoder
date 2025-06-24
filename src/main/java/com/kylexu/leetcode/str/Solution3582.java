package com.kylexu.leetcode.str;

public class Solution3582 {
    public static void main(String[] args) {
        String caption = "Leetcode daily streak achieved";
        String s = new Solution3582().generateTag(caption);
        System.out.println("s = " + s);
    }

    public String generateTag(String caption) {
        StringBuilder rs = new StringBuilder();

        String[] split = caption.trim().split("\\s+");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (i == 0) {
                rs.append(s.toLowerCase());
            } else {
                rs.append(s.substring(0, 1).toUpperCase());
                rs.append(s.substring(1).toLowerCase());
            }
        }

        for (int i = rs.length() - 1; i >= 0; i--) {
            if (!Character.isLetter(rs.charAt(i))) {
                rs.deleteCharAt(i);
            }
        }

        if (rs.length() < 99) {
            return rs.insert(0, "#").toString();
        }

        return rs.insert(0, "#").substring(0, 100);
    }
}
