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
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    List<Integer> item = new LinkedList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[k]);
                    result.add(item);
                    j++;
                    k--;
                    //找到下一轮不重复的下标
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
