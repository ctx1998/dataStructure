package com.dataStructure.array;
/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumInSortedMatrix {
    /**
     *
     * @param target 要找到的数
     * @param array   二维数组
     * @return
     */
    public static boolean Find(int target,int[][] array){
        if(array ==null)
            return false;
        //得到左上角的坐标
        int j=array[0].length-1;
        int i=0;
        while(i<array.length&&j>-1) {
            if (target > array[i][j]){
                i++;
            }else if(target <array[i][j]){
                j--;
            }else
                return true;

        }
        return  false;
    }
    public static void main(String[] args){
        int[][] array={{1,3,5,6},{2,5,7,8},{4,6,8,9}};
        boolean flag=Find(4,array);
        System.out.println(flag);
    }
}
