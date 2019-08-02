package com.dataStructure.array;

import java.util.LinkedList;
import java.util.Queue;

//使用队列实现栈的效果
public class queueToStack {
    private Queue<Integer> dataQueue;
    private Queue<Integer> helpQueue;
    public queueToStack(){
        dataQueue=new LinkedList<Integer>();
        helpQueue=new LinkedList<Integer>();
    }
    //模拟入栈效果
    public void push(Integer obj){
        dataQueue.add(obj);
    }
    //模拟出栈效果
    public Integer pop(){
        helpQueue.clear();
        if(dataQueue.size()==0){
            throw new RuntimeException("Stack is empty!");
        }
        //除了最后一个全部出栈
        while(dataQueue.size()!=1)
        {
            helpQueue.add(dataQueue.poll());
        }
        int res= dataQueue.poll();
        swap();
        return res;
    }
    //模拟获取栈顶元素
    public Integer peek(){
        helpQueue.clear();
        if(dataQueue.size()==0){
            throw new RuntimeException("Stack is empty!");
        }
        //除了最后一个全部出栈
        while(dataQueue.size()!=1)
        {
            helpQueue.add(dataQueue.poll());
        }
        int res= dataQueue.poll();
        helpQueue.add(res);
        swap();
        return res;
    }
    //获取栈顶元素
    public void swap(){
        Queue<Integer> tempQueue=helpQueue;
        helpQueue=dataQueue;
        dataQueue=tempQueue;
    }
    public static void main(String[] args){
        queueToStack queueToStack=new queueToStack();
        for(int i=0;i<15;i++)
            queueToStack.push(i);
        queueToStack.pop();
        System.out.println(queueToStack.peek());
    }
}
