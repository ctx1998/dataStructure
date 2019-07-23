package com.dataStructure.sort;

public class processSort {
    //归并排序
    public int processSort(int[] arr,int L,int R)
    {
        //终止条件
        if(arr==null||L==R||arr.length<2)//当数组长度为0时此时L=0 R=-1无法终止
            return 0;
        //将数组划分成左右两个部分进行左右两部分的排序排完序后,再进行外排的操作
        int mid=L+(R-L)/2;//防止溢出
        // processSrot(arr,L,mid);
        // processSrot(arr,mid+1,R);
        //通过辅助数组进行外排
        //merger(arr,L,mid,R);
        //得到合并过程中的小和，再加上合并前两个子序列的小和之和
        return processSort(arr,L,mid)+processSort(arr,mid+1,R)+merger(arr,L,mid,R);
    }
    public int merger(int[] arr,int L,int mid,int R){
        int[] temp=new int[R-L+1];
        int p1=L;//左侧数组的起始位置
        int p2=mid+1;//右侧数组的起始位置
        int i=0;
        int sum=0;//用来计算小和
        while(p1<=mid&&p2<=R){//如果两个都没有越界
            if(arr[p1]<arr[p2]) {
                sum+=(R-p2+1)*arr[p1];
                temp[i++] = arr[p1++];
            }
            else
                temp[i++]=arr[p2++];
        }
        //只可能有一个越界了
        while(p2<=R)//右侧还没到达
        {
            temp[i++]=arr[p2++];
        }
        while(p1<=mid)
        {
            temp[i++]=arr[p1++];
        }
        for(int j=0;j<temp.length;j++)
            arr[L+j]=temp[j];
        return sum;
    }
}
