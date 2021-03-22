package leetcode.problems;
/**
 * @Author Mr.Yan
 * @Date 2021/3/22 16:25
 **/
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int add = 0;
        int r;
        StringBuffer sb=new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1;
        for (; i >=0||j>=0||add!=0;i--, j--) {
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            r =x+y+add;
            add = r / 10;
            sb.append(r%10);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new Solution415().addStrings("888", "222");
        System.out.println(s);
    }
}
