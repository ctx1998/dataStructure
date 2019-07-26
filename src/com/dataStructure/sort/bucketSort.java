package com.dataStructure.sort;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度为O(N),且不能用基于比较的排序
 */
public class bucketSort {
    public static int bucketSort(int[] arr) {
        int length=arr.length;//得到数组的长度
        if(arr==null||length<2)
            return 0;
        boolean[] isFlag=new boolean[length+1];//用来判断桶中是否有数据
        int[] mins=new int[length+1];//用来存放每个桶中的最小值
        int[] maxs=new int[length+1];//用来存放每个桶中的最大值
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<length;i++)
        {
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);//用来得到数组的最小值与最大值,设置桶的边界
        }
        if(min==max)//整个数组的内容均一样
            return 0;
        for(int i=0;i<length;i++){
            int bid=bucket(arr[i],length,min,max);
            //更新桶的最小值以及最大值,判断是否数组中有内容，有进行比较，没有直接为数组内容
            mins[bid]=isFlag[bid]?Math.min(mins[bid],arr[i]):arr[i];
            maxs[bid]=isFlag[bid]?Math.max(maxs[bid],arr[i]):arr[i];
            isFlag[bid]=true;
        }
        int result=0;
        //第0个桶绝对是有值的
        int lastMax=arr[0];
        //得到最大差值,有值的桶的最小值减去它左边有值的桶的最大值
        for(int i=1;i<=arr.length;i++)//n+1个桶
        {
            if(isFlag[i])
            {
                result=Math.max(result,mins[i]-lastMax);
                //更新桶的最大值
                lastMax=maxs[i];
            }
        }
        return result;
    }

    /**
     *
     * @param num :要存放的数
     * @param len :一共有几个数
     * @param min :最小值
     * @param max:最大值
     * @return
     */
    public static int bucket(long num,long len,long min,long max){
        return (int) ((num - min) * len / (max - min));
    }
    public static void main(String[] args){
        int[] arr=new int[]{78,97,105,101,99,150};
        int result=bucketSort(arr);
        System.out.println(result);
    }
}
