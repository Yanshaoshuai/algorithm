package leetcode.problems;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //从第二次开始 跳过和上次遍历相同的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                //  从第二次开始 跳过和上次遍历相同的数
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //第三个数不需要刻意跳过 如果上次找到了 随着第二个数增大这次就不会满足条件
                while (k > j && nums[k] + nums[j] > -nums[i]) {
                    k--;
                }
                if (k == j) {
                    break;
                }
                //防止出现小于的情况
                if (nums[j] + nums[k] == -nums[j]) {
                    List<Integer> item = new LinkedList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[k]);
                    result.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
