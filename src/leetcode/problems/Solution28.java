package leetcode.problems;

/**
 * @Author yan
 * @Date 2025/12/25
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        //next数组存储的是从开头到此下标对应的子串的最长公共前后缀的长度
        int[] next = new int[needle.length()];
        //固定为0
        next[0] = 0;
        //i为待比较字符串后缀结尾字符下标
        //j为待比较前缀结尾字符下标 也是前一个字串的最长公共前后缀的个数
        for (int i = 1, j = 0; i < needle.length(); i++) {
            //如果最后一个字符不等 跳到前一个下标对应的的最大公共前缀的下一个字符处
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            //如果相等 当前最大公共前缀等于前一个最大公共前缀的个数+1
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        //i为主串索引
        //j为文本串索引
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }
}
