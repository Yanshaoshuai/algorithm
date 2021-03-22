package leetcode.sort.practice;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2020 / 10 /15 14:10
 **/
public class QuickSort {
    public int[] sort(int[] arr){
        if(arr==null||arr.length==0){
            return arr;
        }
        int l=0;
        int r= arr.length-1;
        partition(arr,l,r);
        return arr;
    }

    private void partition(int[] arr, int l, int r) {
        if(r-l<1){
            return;
        }
        int i=l,j=r;
        //找到基准
        int index=l;
        //小于基准放左边 大于基准放右边
        while (true){
            while (arr[l]<=arr[index]&&l<j){
                l++;
            }
            while (arr[r]>=arr[index]&&r>i){
                r--;
            }
            if(l>=r){
                int tmp =arr[index];
                arr[index]=arr[r];
                arr[r]=tmp;
                break;
            }else {
                int tmp=arr[l];
                arr[l]=arr[r];
                arr[r]=tmp;
            }
        }
        //递归左右
        partition(arr,i,r-1);
        partition(arr,r+1,j);
    }

    public static void main(String[] args) {
        int[] nums=new int[]{6,5,4,2,3,1};
        new QuickSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
