package leetcode.stack;

import java.util.Stack;

/**
 * 注意：
 * <p>
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <p>
 * 示例 1：
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class Solution150 {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution150().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.add(token);
            } else {
                String right = stack.pop();
                String left = stack.pop();

                stack.add(String.valueOf(doTheMath(token, left, right)));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String str) {
        if ("+".equals(str)) {
            return true;
        } else if ("-".equals(str)) {
            return true;
        } else if ("*".equals(str)) {
            return true;
        } else if ("/".equals(str)) {
            return true;
        }
        return false;
    }

    private int doTheMath(String operator, String a, String b) {
        return switch (operator) {
            case "+" -> Integer.parseInt(a) + Integer.parseInt(b);
            case "-" -> Integer.parseInt(a) - Integer.parseInt(b);
            case "*" -> Integer.parseInt(a) * Integer.parseInt(b);
            case "/" -> Integer.parseInt(a) / Integer.parseInt(b);
            default -> 0;
        };
    }
}
