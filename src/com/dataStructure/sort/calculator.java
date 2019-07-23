package com.dataStructure.sort;

import java.util.Arrays;

//对数器
public class calculator {
    public static int[] generateArray(int size,int value)
    {
        int s=(int)((size+1)*Math.random());
        int[]arr=new int[s];
        for(int i=0;i<s;i++)
            arr[i]=(int)((value+1)*Math.random()-value*Math.random());
        return arr;
    }
    public static void correctlyMethod(int[] arr)
    {
        Arrays.sort(arr);
    }
    //拷贝数组
    public static int[] copyArray(int[] arr){
        int[] copyArr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copyArr[i]=arr[i];
        }
        return copyArr;
    }
    //判断两个数组是否相等
    public static boolean equalsArray(int[] arr1,int[] arr2)
    {
        if((arr1==null&& arr2!=null)||(arr2==null&&arr1!=null))
            return false;
        if(arr1==null &&arr2==null)
            return true;
        if(arr1.length!=arr2.length)
            return false;
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]!=arr2[i])
            {
                return false;
            }
        }
        return true;
    }
    public static void printArray(int[] arr)
    {
        if(arr!=null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < arr.length ; i++) {
                if(i!=arr.length-1) {
                    sb.append(arr[i]);
                    sb.append(",");
                }
                else{
                    sb.append(arr[i]);
                    sb.append("]");
                }
            }
            System.out.println(sb.toString());
        }
    }
    //测试对数器，检验算法
    public static void main(String[] args)
    {
        int size=10;
        int value=50;
        int times=5000;
        //快速排序
        quickSort qSort=new quickSort();
        //冒泡排序
        bubbleSort bSort=new bubbleSort();
        //插入排序
        insertionSort iSort=new insertionSort();
        //选择排序
        selectionSort sSort=new selectionSort();
        //归并排序
        processSort pSort=new processSort();
        //堆排序
        heapSort hSort=new heapSort();
        boolean succeed=true;
       for(int i=0;i<times;i++)
        {
            int[] arr=generateArray(size,value);
            int[] arr1=copyArray(arr);
            int[] arr2=copyArray(arr);
          /*  bSort.bubbleSort(arr1);
            sSort.selectionSort(arr1);
            iSort.insertionSort(arr1);
            pSort.processSort(arr1,0,arr1.length-1);
            qSort.quickSort(arr1,0,arr.length-1);*/
            hSort.heapSort(arr1);
            correctlyMethod(arr2);
            if(!equalsArray(arr1,arr2))
            {
                //打印测试用例
                printArray(arr);
                //打印时间复杂度低的结果
                printArray(arr1);
                //打印时间复杂度高结果相对正确的方法的结果
                printArray(arr2);
                succeed=false;
                break;
            }
        }
       System.out.println(succeed?"Nice!":"Fucking fucked");
    }
}
