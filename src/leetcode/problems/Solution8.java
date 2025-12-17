package leetcode.problems;


/**
 * @Author yan
 * @Date 2025/12/16
 */
public class Solution8 {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0;
        int sign = 1;

        while (!s.isEmpty() && s.charAt(0) == ' ') {
            s = s.substring(1);
        }
        if (!s.isEmpty()) {
            if (s.charAt(0) == '-') {
                sign = -1;
                s = s.substring(1);
            } else if (s.charAt(0) == '+') {
                s = s.substring(1);
            }
        }
        while (!s.isEmpty() && s.charAt(0) == '0') {
            s = s.substring(1);
        }

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            if (ch <= 9 && ch >= 0) {
                if (lessThanMin(result, ch)) {
                    return Integer.MIN_VALUE;
                }
                if (largeThanMax(result, ch)) {
                    return Integer.MAX_VALUE;
                }
                //转换
                result = result * 10 + sign * ch;
            } else {
                break;
            }
        }
        return result;
    }

    public boolean lessThanMin(int num, int digit) {
        return num < Integer.MIN_VALUE / 10 //除去个位已经小于最小值
                || (num == Integer.MIN_VALUE / 10 && (digit > Math.abs(Integer.MIN_VALUE % 10)));//除去个位后相等 需要判断个位 负数取余还是负数
    }

    public boolean largeThanMax(int num, int digit) {
        return num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && (digit > Integer.MAX_VALUE % 10));
    }
}
