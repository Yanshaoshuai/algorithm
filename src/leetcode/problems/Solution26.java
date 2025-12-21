package leetcode.problems;


/**
 * @Author Mr.Yan
 * @Date 2025/12/16
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        //当前不同的数的个数 也是下个不同的数可以写入的下标
        int count = 1;
        for (int l = 1; l < nums.length; l++) {
            if (nums[l] != nums[l - 1]) {
                nums[count] = nums[l];
                count++;
            }
        }
        return count;
    }

}
