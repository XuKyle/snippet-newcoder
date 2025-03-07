package com.kylexu.leetcode.list;

import java.util.List;

public class Solution1773 {
    public static void main(String[] args) {
        List<List<String>> items = List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone")
        );

        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println(new Solution1773().countMatches(items, ruleKey, ruleValue));
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        return (int) items.stream()
                .map(Item::of)
                .filter(item -> item.filter(ruleKey, ruleValue))
                .count();
    }

    static class Item {
        private String type;
        private String color;
        private String name;

        public static Item of(List<String> list) {
            Item item = new Item();
            item.type = list.get(0);
            item.color = list.get(1);
            item.name = list.get(2);
            return item;
        }

        public boolean filter(String ruleKey, String ruleValue) {
            boolean flag = false;
            switch (ruleKey) {
                case "type":
                    flag = ruleValue.equals(type);
                    break;
                case "color":
                    flag = ruleValue.equals(color);
                    break;
                case "name":
                    flag = ruleValue.equals(name);
                    break;
                default:
            }
            return flag;
        }
    }
}
