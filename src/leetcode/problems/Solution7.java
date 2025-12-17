package leetcode.problems;


/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution7 {
    /**
     * 反转就是每一步除以10的余数与上一步相加乘以10
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }
        return rev;
    }

    /**
     * 此方法用来判断字符串表示的数字是否在Integer范围内
     * 原数字如果是10位数最高位只能是1或者2 反转后最后一位只能是1或者2
     * 所以只需要比较前9位就行了 不会因为个位超出范围
     * 2147483647
     * -2147483648
     * @param strNum 整数表示的字符串
     * @param sign 符号
     */
    private boolean isOutOfRange(String strNum, int sign) {
        String divideTenReverse = strNum.substring(0, strNum.length() - 1);
        if (divideTenReverse.isEmpty()) {
            return false;
        }
        int deviTenNum = Integer.parseInt(divideTenReverse) * sign;
        return !(deviTenNum >= Integer.MIN_VALUE / 10 && deviTenNum <= Integer.MAX_VALUE / 10);
    }
}
