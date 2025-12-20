package leetcode.problems;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> characterMap = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        List<Character> signs = new LinkedList<>();
        signs.addFirst(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!signs.isEmpty()) {
                Character c = characterMap.get(signs.getFirst());
                if (c == null) {
                    return false;
                }
                //如果当前遍历到的符号和栈顶匹配则移除栈顶元素
                if (c == s.charAt(i)) {
                    signs.removeFirst();
                } else {
                    //否则是其他符号的开口
                    signs.addFirst(s.charAt(i));
                }
            } else {
                //如果栈里没有元素说明当前元素是一个开口元素
                signs.addFirst(s.charAt(i));
            }
        }
        return signs.isEmpty();
    }
}
