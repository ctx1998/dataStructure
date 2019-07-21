package com.dataStructure;

public class Main {

    public static void main(String[] args) {
	// write your code here
     /*   int[] arr=new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        int[] score=new int[]{1,2,3};
        for(int j:score){
            System.out.println(j);
        }*/
     Array<Integer> array=new Array<Integer>(20);
     array.add(1);
     array.add(23);
     array.add(1,5);
     array.addFirst(0);
     array.set(0,5);
     System.out.println(array);
     array.remove(2);
     array.removeElement(1);
     System.out.println(array.getSize());
     System.out.println(array);
    Array<Student> array1=new Array<>();
    for(int i=0;i<30;i++) {
        array1.add(new Student("张"+i, i));
    }
    System.out.println(array1+"capacity:"+array1.getCapacity());
    for(int j=0;j<27;j++)
    {
        array1.remove(j);
    }
        System.out.println(array1+""+array1.getCapacity());
    }
}
