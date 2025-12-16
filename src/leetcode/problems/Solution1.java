package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /03 13:40
 **/
public class Solution1 {
    /**
     * 查找表
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numIndexMap=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if(numIndexMap.get(target-nums[i])==null){
                numIndexMap.put(nums[i],i);
                continue;
            }
            return new int[]{i,numIndexMap.get(target-nums[i])};
        }
        return null;
    }
}
