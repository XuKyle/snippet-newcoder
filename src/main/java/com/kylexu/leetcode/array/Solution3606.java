package com.kylexu.leetcode.array;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 示例 1：
 * <p>
 * 输入： code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]
 * <p>
 * 输出： ["PHARMA5","SAVE20"]
 * <p>
 * 解释：
 * <p>
 * 第一个优惠券有效。
 * 第二个优惠券的标识符为空（无效）。
 * 第三个优惠券有效。
 * 第四个优惠券的标识符包含特殊字符 @（无效）。
 * 示例 2：
 * <p>
 * 输入： code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]
 * <p>
 * 输出： ["ELECTRONICS_50"]
 * <p>
 * 解释：
 * <p>
 * 第一个优惠券无效，因为它未激活。
 * 第二个优惠券有效。
 * 第三个优惠券无效，因为其业务类别无效。
 */
public class Solution3606 {
    public static void main(String[] args) {
//        当以下所有条件都满足时，优惠券被认为是 有效的 ：
//
//        code[i] 不能为空，并且仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）组成。
//        businessLine[i] 必须是以下四个类别之一："electronics"、"grocery"、"pharmacy"、"restaurant"。
//        isActive[i] 为 true 。
//        返回所有 有效优惠券的标识符 组成的数组，按照以下规则排序：
//
//        先按照其 businessLine 的顺序排序："electronics"、"grocery"、"pharmacy"、"restaurant"。
//        在每个类别内，再按照 标识符的字典序（升序）排序。
//        输出： ["ELECTRONICS_50"]
        String[] code = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine = {"grocery", "electronics", "invalid"};
        boolean[] isActive = {false, true, true};

        List<String> strings = new Solution3606().validateCoupons(code, businessLine, isActive);
        System.out.println("strings = " + strings);
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> rs = new ArrayList<>();
        Map<Integer, String> sorter = new HashMap<>();

        for (int i = 0; i < code.length; i++) {
            String c = code[i];
            if (isValidCode(c)) {
                String busi = businessLine[i];
                if ("electronics".equals(busi)
                        || "grocery".equals(busi)
                        || "pharmacy".equals(busi)
                        || "restaurant".equals(busi)) {
                    if (isActive[i]) {
                        rs.add(i);
                        sorter.put(i, busi);
                    }
                }
            }
        }

//        rs.sort(
//                (o1, o2) -> {
//                    if (sorter.getOrDefault(o1, "").equals(sorter.get(o2))) {
//                        return o1.compareTo(o2);
//                    }
//                    return sorter.getOrDefault(o1, "").compareTo(sorter.get(o2));
//                }
//        );

//        "electronics"、"grocery"、"pharmacy"、"restaurant"

//        rs.sort(Comparator.<Integer, String>comparing(integer -> {
//                            String co = code[integer];
//                            if ("electronics".equals(co)) {
//                                return "a";
//                            } else if ("grocery".equals(co)) {
//                                return "b";
//                            } else if ("pharmacy".equals(co)) {
//                                return "c";
//                            } else if ("restaurant".equals(co)) {
//                                return "d";
//                            }
//                            return "";
//                        })
//                        .thenComparing(Comparator.comparing(index -> code[index]))
//        );

        System.out.println("Qf8NjqOTYp".compareTo("w4xOTEM20C"));

        rs.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (businessLine[o1].equals(businessLine[o2])) {
                    return code[o1].compareTo(code[o2]);
                } else {
                    if ("electronics".equals(businessLine[o1])) {
                        return -1;
                    }
                    if ("grocery".equals(businessLine[o1])) {
                        if ("pharmacy".equals(businessLine[o2]) || "restaurant".equals(businessLine[o2])) {
                            return -1;
                        }
                    }

                    if ("pharmacy".equals(businessLine[o1])) {
                        if ("restaurant".equals(businessLine[o2])) {
                            return -1;
                        }
                    }

                    return 1;
                }
            }
        });

        return rs.stream().map(index -> code[index]).toList();
    }

    private boolean isValidCode(String code) {
//        code[i] 不能为空，并且仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）组成。
        if (code == null || code.isEmpty()) {
            return false;
        }

        Pattern compile = Pattern.compile("^[a-zA-Z0-9_]*$");
        Matcher matcher = compile.matcher(code);
        return matcher.find();
    }
}
