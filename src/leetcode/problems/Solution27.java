package leetcode.problems;

public class Solution27 {
    /**
     * count记录不等于val的数量 也是下一个不等于val的数可以写入的下标
     * 找到不等于count的数时 把该数填充到count下标处
     * 12234 val=2 => count=0 i=0  [1] count++ i++
     * count=1 i=1  [1] i++
     * count=1 i=2  [1] i++
     * count=1 i=3  [1,3] count++ i++
     * count=2 i=4  [1,3,4] count++ i++
     * count=3 i=5  i==num.length  跳出循环
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    /**
     * 假如 12345 val=1  removeElement需要把后面4个元素都往前移动一位 23455
     * removeElementPlus 使用left记录val的下标然后从right找到不等于val的值赋值到下标
     * 对于12345 val=1的情况只需要赋值一次即可 52345
     */
    public int removeElementPlus(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
