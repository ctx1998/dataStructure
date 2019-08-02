package com.dataStructure.array;
/*
    打印旋转队列
 */
public class RotateMatrix {
    //打印二维数组
    public static void printMatrix(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+"    ");
            System.out.println();
        }
    }
    public static void rotate(int[][] arr){
        int tR=0;
        int tC=0;
        int dR=arr.length-1;
        int dC=arr[0].length-1;
        while(tR<dR&&tC<dC){
            rotateEdge(arr,tR++,tC++,dR--,dC--);
        }
    }
    public static void rotateEdge(int[][] arr,int tR,int tC,int dR,int dC){
        int times=dR-tR;
        int temp=0;
        for(int i=0;i!=times;i++){
             temp=arr[tR][tC+i];
            temp = arr[tR][tC + i];
            arr[tR][tC + i] = arr[dR - i][tC];
            arr[dR - i][tC] = arr[dR][dC - i];
            arr[dR][dC - i] = arr[tR + i][dC];
            arr[tR + i][dC] = temp;
        }
    }
    public static void main(String[] args){
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(arr);
        printMatrix(arr);
    }
}
