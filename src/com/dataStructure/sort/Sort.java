package com.dataStructure.sort;

public class Sort {
    //冒泡排序
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
    //选择排序
    public void selectionSort(int[] arr) {
        int length=arr.length;
        if(arr==null||length<2)
            return ;
        for(int i=0;i<length;i++)
        {
            int minIndex=i;//最小值所在的索引处
            for(int j=i+1;j<length;j++)
            {
                if(arr[minIndex]>arr[j])
                    minIndex=j;
            }
            swap(arr,i,minIndex);
        }
    }
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
