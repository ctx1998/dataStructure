package com.dataStructure.array;

/**
 * 使用数组实现栈
 */
public class arrayStack {
    Integer[] array;
    int index;

    /**
     * initCount 指的是初始数组的容量
     * @param initCount
     */
    public arrayStack(Integer initCount) {
        array=new Integer[initCount];
        index=0;
    }
    /**
     * 入栈
     */
    public void push(Integer obj)
    {
        //判断此时栈是否满
        if(index==array.length)
            throw new IndexOutOfBoundsException("The queue is full");
        array[index++]=obj;
    }
    /**
     * 出栈
     */
    public Integer pop(){
        if(index ==0)
            throw new IndexOutOfBoundsException("The queue is empty");
        return array[--index];
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public Integer peek(){
        if(index!=0)
        return array[index-1];
        else
           return null;
    }
    public static void main(String[] args){
        arrayStack as=new arrayStack(15);
        for(int i=0;i<15;i++)
            as.push(i);
        Integer obj=as.pop();
        System.out.println(obj);
        as.push(15);
        System.out.println(as.peek());
    }
}
