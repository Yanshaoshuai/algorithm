package leetcode.problems;


/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution14 {
    /**
     *  Sn=S(S(n-1),n)
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i + 1 < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    private String longestCommonPrefix(String first, String second) {
        int i = 0;
        int min = Math.min(first.length(), second.length());
        while (i < min) {
            if (first.charAt(i) == second.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return first.substring(0, i);
    }

    public static void main(String[] args) {
        String prefix = new Solution14().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(prefix);
    }
}
