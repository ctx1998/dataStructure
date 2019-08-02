package com.dataStructure.array;

/**
 * 转圈打印数组
 */
public class PrintMatrixSpiralOrder {
    //给定数组以及左上角以及右下角进行转圈的操作tR指的是topRow 左上角的行坐标，tC指的是topColumn 左上角的列坐标
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        //两者在一行
        if(tR==dR)
        {
            for(int i=tC;i<=dC;i++)
                System.out.print(m[tR][i]+"    ");
        }
        //两者在一列
        else if(tC==dC){
            for(int i=tR;i<dR;i++) {
                System.out.print(m[i][tC]+"     ");
            }
        }else if(tC>dC||tR>dR)
            throw new RuntimeException("index error!");
        else{
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }
    public static void spiralOrderPrint(int[][] arr){
        if(arr==null)
            return;
        int tR=0;
        int tC=0;
        int dR=arr.length-1;
        int dC=arr[0].length-1;
        while(tR<=dR&&tC<=dC)
            printEdge(arr,tR++,tC++,dR--,dC--);


    }
    public static void main(String[] args){
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        spiralOrderPrint(matrix);
    }

}
