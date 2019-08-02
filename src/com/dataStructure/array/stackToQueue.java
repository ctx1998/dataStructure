package com.dataStructure.array;

import java.util.Stack;

/**
 * 使用栈模拟队列
 */
public class stackToQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    public stackToQueue(){
        pushStack=new Stack<Integer>();
        popStack=new Stack<Integer>();
    }
    public void push(Integer obj) {
        pushStack.push(obj);
    }
    public Integer pop(){
        if(pushStack.empty()&&popStack.empty())
            throw new RuntimeException("Queue is empty!");
        else if(popStack.empty()){
            while(!pushStack.empty())
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
    public Integer peek(){
        if(pushStack.empty()&&popStack.empty())
            throw new RuntimeException("Queue is empty!");
        else if(popStack.empty()){
            while(!pushStack.empty())
                popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }
    public static void main(String[] args){
        stackToQueue stackToQueue=new stackToQueue();
        for(int i=0;i<15;i++)
            stackToQueue.push(i);
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.peek());
    }
}
