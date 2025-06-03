package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String rs = new Solution6().convert(s, numRows);
        System.out.println("rs = " + rs);
    }

    public String convert(String s, int numRows) {
        List<List<Character>> characterList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            characterList.add(new ArrayList<>());
        }

        boolean down = true;

        int n = s.length();
        int currentLine = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            characterList.get(currentLine).add(c);

            if (numRows != 1) {
                if (currentLine == numRows - 1) {
                    down = false;
                }

                if (currentLine == 0) {
                    down = true;
                }

                if (down) {
                    currentLine++;
                } else {
                    currentLine--;
                }
            }
        }

        StringBuilder rs = new StringBuilder();

        for (List<Character> characters : characterList) {
            for (Character character : characters) {
                rs.append(character);
            }
        }

        return rs.toString();
    }
}
