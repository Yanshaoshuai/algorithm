package leetcode;

import leetcode.sort.practice.MergeSort;

import java.util.Arrays;

/**
 * @Author Mr.Yan
 * @Date 2021/3/22 10:50
 **/
public class Main {
    static class MergeSort{
        private int[] aux=null;
        public int[] sort(int[] arr){
            if(arr==null||arr.length<=1){
                return arr;
            }
            aux=new int[arr.length];
            mergeSort(arr,0,arr.length-1);
            return arr;
        }

        private void mergeSort(int[] arr, int l, int r) {
            if(l>=r){
                return;
            }
            int mid=(l+r)/2;
            //左边拆分
            mergeSort(arr,l,mid);
            //右边拆分
            mergeSort(arr,mid+1,r);
            //归并左右
            merge(arr,l,mid,r);
        }

        private void merge(int[] arr, int l, int mid, int r) {
            int i=l,j=mid+1;
            for (int k = l; k <=r; k++) {
                aux[k]=arr[k];
            }
            for (int k = l; k <=r; k++) {
                if(i>mid){
                    arr[k]=aux[j++];
                }else if(j>r) {
                    arr[k]=aux[i++];
                }else if(aux[i]<aux[j]){
                    arr[k]=aux[i++];
                }else {
                    arr[k]=aux[j++];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] sort = new MergeSort().sort(new int[]{6, 3, 2, 1, 5});
        Arrays.stream(sort).forEach(t-> System.out.println(t));
    }
}
