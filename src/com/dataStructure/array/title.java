package com.dataStructure.array;

import java.util.Stack;

/**
 * 要求有一个数组，要得到数组中的最小值，且要求时间复杂度为O(1)
 */
public class title {
       private Stack<Integer> dataStack=new Stack<Integer>();
       private Stack<Integer> minStack=new Stack<Integer>();
       public void push(Integer obj){

           dataStack.push(obj);
           if(minStack.size()!=0) {
               //使用obj与min栈栈顶进行比较，obj小就入栈obj，栈顶小就再次入栈栈顶
               Integer top = minStack.peek();
               if (obj <= top)
                   minStack.push(obj);
               else
                   minStack.push(top);
           }else
               minStack.push(obj);
       }
       public Integer pop(){
           minStack.pop();
           return dataStack.pop();
       }
       //获得到最小值，即返回minStack的栈顶元素
       public Integer getMin() {
           return  minStack.peek();
       }
       public static void main(String[] args){
           title t=new title();
           for(int i=0;i<15;i++)
               t.push(i);
           t.pop();
           Integer min=t.getMin();
           System.out.println(min);
       }
}
