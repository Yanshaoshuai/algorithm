package leetcode;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import leetcode.sort.practice.MergeSort;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2021/3/22 10:50
 **/
public class Main {
   static class AddStr{
       public String addStr(String num1,String num2){
           int l=0,r=0;
           StringBuffer sb=new StringBuffer();
           for (int i = num1.length()-1,j=num2.length()-1; i >=0||j>=0||l>0;i--,j--) {
               int x=i>=0?num1.charAt(i)-'0':0;
               int y=j>=0?num2.charAt(j)-'0':0;
               r=x+y+l;
               l=r/10;
               sb.append(r%10);
           }
           return sb.reverse().toString();
       }
   }
   static class MergeSort{
       private int[] aux=null;
       public int[] sort(int[] nums){
           if(nums==null||nums.length==0){
               return nums;
           }
           if(aux==null){
               aux=new int[nums.length];
           }
           //先拆分 再合并
           divide(nums,0,nums.length-1);
           return nums;
       }

       private void divide(int[] nums, int l, int r) {
           if(r-l<1){
               return;
           }
           int mid=(l+r)/2;
           //先拆左边
           divide(nums,l,mid);
           //再拆右边
           divide(nums,mid+1,r);
           //自底向上合并
           merge(nums,mid,l,r);
       }

       private void merge(int[] nums, int mid, int l, int r) {
          int i=l,j=mid+1;
          for(int k=l;k<=r;k++){
              aux[k]=nums[k];
          }
           for (int k = l; k <=r; k++) {
               if(i>mid){
                   nums[k]=aux[j++];
               }else if(j>r){
                   nums[k]=aux[i++];
               }else if(aux[i]<aux[j]){
                   nums[k]=aux[i++];
               }else {
                   nums[k]=aux[j++];
               }
           }
       }
   }

   static class QuickSort{
       public int[] sort(int[]nums){
           quickSort(nums,0,nums.length-1);
           return nums;
       }

       private void quickSort(int[] nums, int l, int r) {
           if(r-l<1){
               return;
           }
           //选定基准
           //小于基准移到左边
           //大于基准移到右边
           int index=l;
           int i=l,j=r;
           while (true){
               while (nums[i]<=nums[index]&&i<r){
                   i++;
               }
               while (nums[j]>=nums[index]&&j>l){
                   j--;
               }
               if(i<j){
                   int tmp=nums[i];
                   nums[i]=nums[j];
                   nums[j]=tmp;
               }else {
                   int tmp=nums[j];
                   nums[j]=nums[index];
                   nums[index]=tmp;
                   break;
               }
           }
           quickSort(nums,l,j-1);
           quickSort(nums,j+1,r);
       }
   }

    public static void main(String[] args) {
        String s = new AddStr().addStr("1111111", "9999999999999");
        System.out.println(s);
        System.out.println("==========归并排序===========");
        int[] sort = new MergeSort().sort(new int[]{9, 7, 8, 4, 5, 2, 1});
        Arrays.stream(sort).forEach(t-> System.out.println(t));
        System.out.println("=========快速排序===========");
        int[] sort1 = new QuickSort().sort(new int[]{9, 7, 8, 4, 5, 2, 1});
        Arrays.stream(sort1).forEach(t-> System.out.println(t));
    }
}
