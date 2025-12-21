package leetcode.problems;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2025/12/16
 */
public class Solution6 {
    /**
     * 每个字符所在的行下标从 0～numRows-1 先递增 再从numRows-1~0 递减
     * 按顺序记录每个字符行的位置
     * 把相同行的字符按照顺序添加到一个字符串中
     * 按行号顺序拼接在一起即可
     */
    public String convert(String s, int numRows) {
        //调转方向的最小单位是1 行下标为0的情况下会越界
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rowList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rowList.add(new StringBuilder());
        }
        int i = 0;
        //先设置为-1 让第一次判断正确转换方向(转成+1)
        int direction = -1;
        for (int j = 0; j < s.length(); j++) {
            rowList.get(i).append(s.charAt(j));
            if (i == 0 || i == numRows - 1) {
                direction = -direction;
            }
            i += direction;
        }
        return String.join("", rowList);
    }
}
