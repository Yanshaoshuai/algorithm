package leetcode.problems;


import java.util.Arrays;

/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k) {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return sum;
                }
                //如果当前和离target更近 则更新result
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result=sum;
                }
                //如果sum<target 需要增大sum 反之需要减小sum 找到下一个不同的值
                if(sum<target){
                    j++;
                    while (j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                }else {
                    k--;
                    while (j<k&&nums[k]==nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
