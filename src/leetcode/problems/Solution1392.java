package leetcode.problems;

/**
 * @Author yan
 * @Date 2025/12/23
 */
public class Solution1392 {

    /**
     * 暴力求解 O(n^2)
     */
    public String longestPrefixBruteForce(String s) {
        int l = 0, r = s.length() - 1;
        int max = 0;
        while (l < s.length() - 1) {
            if (s.substring(0, l + 1).equals(s.substring(r))) {
                max = Math.max(max, l + 1);
            }
            l++;
            r--;
        }
        return s.substring(0, max);
    }

    /**
     * 找最长相同前后缀返回长度
     * A -> 0
     * ABCDEFABC -> ABC 3
     * i=1             i=2         i=3             i=4             i=5                 i=6               i=7                  i=8
     * ABCDEFABC      ABCDEFABC     ABCDEFABC     ABCDEFABC        ABCDEFABC          ABCDEFABC          ABCDEFABC          ABCDEFABC
     *  ABCDEFABC      ABCDEFABC      ABCDEFABC      ABCDEFABC         ABCDEFABC           ABCDEFABC           ABCDEFABC           ABCDEFABC
     * ABABA -> ABA 3
     * ABABABAB -> ABABAB 6
     */
    /**
     * for (int i = 1, j = 0; i < m; i++) {
     *             while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
     *                 j = pi[j - 1];
     *             }
     *             if (needle.charAt(i) == needle.charAt(j)) {
     *                 j++;
     *             }
     *             pi[i] = j;
     *         }
     */
    public String longestPrefix(String s) {
        int[] next = new int[s.length()];
        //i是后缀开始下标
        //j是前缀开始下标
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j=next[j-1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return s.substring(0, next[s.length() - 1] + 1);
    }
}
