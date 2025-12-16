package leetcode.problems.stack;

import java.util.LinkedList;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /11 18:55
 **/
public class Solution20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack=new LinkedList<>();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character c = stack.peek();
                stack.pop();
                char match = switch (s.charAt(i)) {
                    case ')' -> '(';
                    case ']' -> '[';
                    case '}' -> '{';
                    default -> ' ';
                    //获取和当前符号匹配的符号
                };
                if (c!=match){
                    //判断栈顶符号是否和当前符号的匹配符号相等
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str="{{([()])}}";
        Solution20 solution20=new Solution20();
        boolean valid = solution20.isValid(str);
        System.out.println(valid);
    }
}
