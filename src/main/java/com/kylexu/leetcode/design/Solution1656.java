package com.kylexu.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution1656 {
    public static void main(String[] args) {
//        [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]

        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}


class OrderedStream {
    String[] db;
    int index;
    int size;

    public OrderedStream(int n) {
        this.size = n;
        this.db = new String[n];
        this.index = 0;
    }

    public List<String> insert(int idKey, String value) {
        int i = idKey - 1;
        this.db[i] = value;

        List<String> rs = new ArrayList<>();
        for (int j = index; j < size; j++) {
            if (this.db[j] != null) {
                rs.add(this.db[j]);
            } else {
                index = j;
                break;
            }
        }
        return rs;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */