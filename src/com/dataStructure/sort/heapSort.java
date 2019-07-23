package com.dataStructure.sort;

/**
 * 堆排序
 */
public class heapSort {
    //插入一个数使其在原有的大大根堆上在变成大根堆
    public void heapInsert(int[] arr,int index){
        //其中arr的内容已经为大根堆，将index位置的值加入进去,使其再变成大根堆
        while(arr[index]>arr[(index-1)/2])//将其先放到最后一个位置上再与父节点进行比较
        {
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    //index指的是要调整的位置的数,size指的数要处理的最大区域值
    public  void heapify(int[] arr,int index,int size){
        //此时的arr[index]的值没有形成大根堆意思即为，它的子孩子的值比其大，首先应该判断是否还有子孩子
        int left=(index*2)+1;
        while(left<size){//没有越界
            //找到两个子孩子中值较大的值
            int largest=left+1<size&&arr[left+1]>arr[left]?left+1:left;
            largest = arr[largest] > arr[index] ? largest : index;//判断子孩子是否比自己大
            if (largest == index) {//如果没有，此时不需要再做换值的操作
                break;
            }
            //找到之后进行换值的操作
            swap(arr,index,largest);
            index=largest;
            left=(index*2)+1;
        }
    }
    public void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public void heapSort(int[] arr)
    {
        if(arr==null||arr.length<2)
            return;
        //首先进行大根堆，一个个进行堆插入的操作
        for(int i=0;i<arr.length;i++)
            heapInsert(arr,i);
        int size=arr.length-1;
        //将大根堆的堆顶与最后一个值进行更换，并去掉它
        swap(arr,0,size);
        while(size>0)
        {
            heapify(arr,0,size);//由于第一个值变小，所以需要进行heapify的操作，让其重新成为大根堆
            swap(arr,0,--size);
        }

    }
}
