package leetcode.problems;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int r = nums.length - 1;
                while (k < r) {
                    //转成long 防止越界
                    if ((long) nums[i] + nums[j] + nums[k] + nums[r] < target) {
                        k++;
                    } else if ((long) nums[i] + nums[j] + nums[k] + nums[r] > target) {
                        r--;
                    } else {
                        List<Integer> item = new LinkedList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        item.add(nums[r]);
                        result.add(item);
                        k++;
                        r--;
                        while (k < r && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
