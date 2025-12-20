package leetcode.problems;


import java.util.LinkedList;
import java.util.List;

/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result, n, new StringBuilder());
//        backtrackPlus(result, n, new StringBuilder(), 0, 0);
        return result;
    }

    /**
     * 暴力遍历所有情况并判断
     */
    private void backtrack(List<String> result, int n, StringBuilder stringBuilder) {
        if (stringBuilder.length() == n * 2) {
            String string = stringBuilder.toString();
            if (valid(string)) {
                result.add(string);
            }
        } else {
            //尝试左括号
            stringBuilder.append("(");
            backtrack(result, n, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            //尝试右括号
            stringBuilder.append(")");
            backtrack(result, n, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    /**
     * 更优解 不用遍历所有情况
     */
    private void backtrackPlus(List<String> result, int n, StringBuilder stringBuilder, int open, int close) {
        if (open > n || close > open) {
            return;
        }
        //满足长度条件 且open==n 每一步close都小于open的就都是合法的
        if (stringBuilder.length() == n * 2) {
            String string = stringBuilder.toString();
            if (valid(string)) {
                result.add(string);
            }
        } else {
            //尝试左括号
            stringBuilder.append("(");
            backtrackPlus(result, n, stringBuilder, open + 1, close);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            //尝试右括号
            stringBuilder.append(")");
            backtrackPlus(result, n, stringBuilder, open, close + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    private boolean valid(String string) {
        int balance = 0;
        for (char c : string.toCharArray()) {
            //是左括号就加一
            if (c == '(') {
                balance++;
            } else {
                //右括号减一
                balance--;
            }
            //如果右括号数量大于左括号数量肯定不符合题意
            if (balance < 0) {
                break;
            }
        }
        //最后等于0就表明左右括号匹配 且中间没有出现左右乱序
        return balance == 0;
    }
}
