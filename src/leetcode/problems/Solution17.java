package leetcode.problems;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.Yan
 * @Date 2025/12/16
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String[]> numChars = new HashMap<>() {{
            put(2, new String[]{"a", "b", "c"});
            put(3, new String[]{"d", "e", "f"});
            put(4, new String[]{"g", "h", "i"});
            put(5, new String[]{"j", "k", "l"});
            put(6, new String[]{"m", "n", "o"});
            put(7, new String[]{"p", "q", "r", "s"});
            put(8, new String[]{"t", "u", "v"});
            put(9, new String[]{"w", "x", "y", "z"});
        }};

        List<String[]> charList = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            charList.add(numChars.get(digits.charAt(i) - '0'));
        }

        List<String> result = new LinkedList<>();

        backtrack(0, result, numChars, digits, new StringBuilder());
        return result;
    }

    private void backtrack(int deep, List<String> result, Map<Integer, String[]> numChars, String digits, StringBuilder currentStr) {
        if (deep == digits.length()) {
            result.add(currentStr.toString());
        } else {
            String[] chars = numChars.get(digits.charAt(deep) - '0');
            for (String aChar : chars) {
                currentStr.append(aChar);
                //深入此字母结尾的分支
                backtrack(deep + 1, result, numChars, digits, currentStr);
                //回退 以尝试其他字母
                currentStr.deleteCharAt(deep);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Solution17().letterCombinations("23");
        System.out.println(strings);
    }
}
