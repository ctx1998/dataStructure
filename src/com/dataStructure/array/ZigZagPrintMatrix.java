package com.dataStructure.array;

public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] m){
        boolean flag=true;
        int tR=0;
        int tC=0;
        int dR=0;
        int dC=0;
        int endR=m.length-1;
        int endC=m[0].length-1;
        while(tR!=endR+1){
            printLevel(m,tR,tC,dR,dC,flag);
            tR=tC==endC?tR+1:tR;
            tC=tC==endC?endC:tC+1;
            dC=dR==endR?dC+1:dC;
            dR=dR==endR?endR:dR+1;
            flag=!flag;
        }
        System.out.println();
    }
    //给左下角以及右上角的值，斜对角线进行打印
    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,boolean f) {
        if(f){
            while(dR!=tR-1)
            System.out.print(m[dR--][dC++]+"      ");
        }else {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + "      ");
            }
        }

    }

    //主函数
    public static void main(String[] args){
        int [][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrixZigZag(m);
    }
}
