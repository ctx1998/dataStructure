package com.dataStructure.sort;

import java.util.Arrays;

public class quickSort {
    public void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    //快速排序
    public void quickSort(int[] arr,int L,int R){
        if(arr==null||arr.length<2)
            return;
        if(L<R) {
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }
    //返回等于最后一个数的等于区域
    public int[] partition(int[] arr, int L, int R) {
        int less=L-1;
        int more=R;//大于区包含x
        while(L<more) {
            if(arr[L]<arr[R])
                swap(arr,++less,L++);
            else if(arr[L]>arr[R])
                swap(arr,L,--more);
            else
                L++;
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }


}
