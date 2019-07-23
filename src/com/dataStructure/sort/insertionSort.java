package com.dataStructure.sort;

/**
 * 插入排序
 */
public class insertionSort {
    //插入排序
    public void insertionSort(int[] arr){
        int length=arr.length;
        if(arr==null||length<2)
            return;
        for(int i=0;i<length;i++) {
            for(int j=i;j>0;j--)
            {
                if(arr[j]<arr[j-1])
                    swap(arr,j,j-1);
            }
        }
    }
    public void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

}
