package com.kylexu.test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<LeftTable> left = new ArrayList<>();
//        left.add(new LeftTable(1,"xuguoming"));
//        left.add(new LeftTable(2,"guoming"));
//
//        List<RightTable> right = new ArrayList<>();

        List<Map<String, String>> left = new ArrayList<>();
        left.add(Map.of("id", "1", "name", "xuguoming"));
        left.add(Map.of("id", "2", "name", "guoming"));

        List<Map<String, String>> right = new ArrayList<>();
        right.add(Map.of("id", "1", "sex", " 男"));
        right.add(Map.of("id", "3", "sex", "女"));


        // 内连接
        List<Map<String, String>> rs = new ArrayList<>();
        for (Map<String, String> leftMap : left) {
            String leftId = leftMap.get("id");

            HashMap<String, String> inner = new HashMap<>();
            inner.put("id", leftId);
            inner.put("name", leftMap.get("name"));

            boolean match = false;
            for (Map<String, String> rightMap : right) {
                String rightId = rightMap.get("id");
                if (leftId.equals(rightId)) {
                    match = true;
                    inner.put("sex", rightMap.get("sex"));
                }
            }
            if (match) {
                rs.add(inner);
            }
        }
        System.out.println("rs = " + rs);
        // 左连接
        List<Map<String, String>> rs1 = new ArrayList<>();
        for (Map<String, String> leftMap : left) {
            String leftId = leftMap.get("id");

            HashMap<String, String> inner = new HashMap<>();
            inner.put("id", leftId);
            inner.put("name", leftMap.get("name"));
            for (Map<String, String> rightMap : right) {
                String rightId = rightMap.get("id");
                if (leftId.equals(rightId)) {
                    inner.put("sex", rightMap.get("sex"));
                }
            }
            rs1.add(inner);
        }
        System.out.println("rs = " + rs1);

        // 全连接
        List<Map<String, String>> rs2 = new ArrayList<>();

        List<Map<String, String>> all = new ArrayList<>();
        all.addAll(left);
        all.addAll(right);

        Set<String> idAdd = new HashSet<>();

        for (Map<String, String> allMap : all) {
            String allId = allMap.get("id");

            if (idAdd.contains(allId)) {
                continue;
            }

            HashMap<String, String> inner = new HashMap<>();
            inner.put("id", allId);

            for (Map<String, String> leftMap : left) {
                String leftId = leftMap.get("id");
                if (allId.equals(leftId)) {
                    inner.put("name", leftMap.get("name"));
                }
            }

            for (Map<String, String> rightMap : right) {
                String rightId = rightMap.get("id");
                if (allId.equals(rightId)) {
                    inner.put("sex", rightMap.get("sex"));
                }
            }
            idAdd.add(allId);
            rs2.add(inner);
        }
        System.out.println("rs2 = " + rs2);


    }


    static class LeftTable {
        private Integer id;
        private String name;

        public LeftTable(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class RightTable {
        private Integer id;
        private String name;

        public RightTable(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
