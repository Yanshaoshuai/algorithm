package leetcode.problems;

/**
 * @Author yan
 * @Date 2025/12/17
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        String strNum = String.valueOf(x);
        for (int i = 0, j = strNum.length() - 1; i < j; i++, j--) {
            if (!(strNum.charAt(i) == strNum.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
