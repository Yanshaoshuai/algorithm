package leetcode.problems;


/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int max = 1;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            //奇数 [i-1,i+1] [i-2,i+2]
            int k = 1;
            int l = i - k, r = i + k;
            int len = 2 * k + 1;
            while (l >= 0 && r <= s.length() - 1) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (len > max) {
                        max = len;
                        result = s.substring(l, r + 1);
                    }
                    k++;
                    l = i - k;
                    r = i + k;
                    len = 2 * k + 1;
                } else {
                    break;
                }
            }
            //偶数  [i i+1] [i-1,i+2]
            k = 0;
            l = i - k;
            r = i + 1 + k;
            len = 2 * (k + 1);
            while (l >= 0 && r <= s.length() - 1) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (len > max) {
                        max = len;
                        result = s.substring(l, r + 1);
                    }
                    k++;
                    l = i - k;
                    r = i + 1 + k;
                    len = 2 * (k + 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
