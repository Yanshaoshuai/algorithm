package leetcode.problems.array;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /02 16:36
 **/
public class Solution167 {
   /* public int[] twoSum(int[] numbers, int target) {
        //i
        //找target-nums[i] 二分查找
    }*/

    /**
     * 对撞指针
     * time O(n)
     * space O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while (i<j){
            if(numbers[i]+numbers[j]<target){
                i++;
                continue;
            }else if (numbers[i]+numbers[j]>target){
                j--;
                continue;
            }
            return new int[]{i+1,j+1};
        }
        return null;
    }
}
