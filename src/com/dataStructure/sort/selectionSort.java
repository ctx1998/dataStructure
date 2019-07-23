package com.dataStructure.sort;
//选择排序
public class selectionSort {

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
    public void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
