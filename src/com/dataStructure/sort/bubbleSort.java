package com.dataStructure.sort;

/**
 * 冒泡排序
 */
public class bubbleSort {

    public void bubbleSort(int[] arr)
    {
        if(arr==null||arr.length<2)
        {
            return;//如果数组为null或者只有一个元素不需要排序
        }
        int length=arr.length;
        for(int j=0;j<length;j++) {
            for (int i = 0; i < length - j-1; i++) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            }
        }
    }
    public void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
