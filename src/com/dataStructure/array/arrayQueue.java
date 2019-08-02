package com.dataStructure.array;

/**
 * 将数组转换为队列
 */
public class arrayQueue {
    private Integer[] array;
    private int start;
    private int end;
    private int size;
    public arrayQueue(Integer initCount){
        array=new Integer[initCount];
        start=0;
        end=0;
        size=0;
    }
    //入队列
    public void push(Integer obj){
        //如果队列满了不能入队列
        if(start==end && size!=0){
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        array[end]=obj;
        end=end+1>=array.length?0:end+1;
    }
    //出队列
    public Integer pop(){
        if(size==0)
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        size--;
        int temp=array[start];
        start=start+1>=array.length?0:start+1;
        return temp;
    }
    public Integer peek(){
        if (size==0)
            return null;
        else
            return array[start];
    }
    public static void main(String[] args){
        arrayQueue aq=new arrayQueue(15);
        for(int i=0;i<15;i++)
            aq.push(i);
        Integer obj=aq.pop();
        System.out.println(obj);
        aq.push(15);
        System.out.println(aq.peek());
    }
}
