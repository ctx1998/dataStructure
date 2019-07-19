package com.dataStructure;

/**
 * 用于二次封装数组类
 */
public class Array<T> {
    private T[] data;
    private int size;//表示数组元素的个数


    /**
     * capacity用于表示数组的长度
     * @param capacity
     */
    public Array(int capacity){
        data=(T[])new Object[capacity];//不能直接使用泛型构造函数，可以先构造int类型再转换成泛型的类型
        size=0;
    }

    public Array(){
        this(10);//如果没有传参,默认为10 capacity:10是Intellij给的语义表明10是用来给capacity传值
    }

    /**
     * 用于返回数组中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * <dl>
     *     <dt>用于返回数组中的容量</dt>
     * </dl>
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * <dl>
     *     <dt>向数组末尾中添加元素</dt>
     * </dl>
     * @param t
     */
    public void add(T t){
        //判断是否超过了容量
        if(size==data.length)
            resize(2*data.length);
        else {
            data[size] = t;
            size++;
        }
    }
    //在数组首位放置元素
    public void addFirst(T t)
    {
        add(0,t);
    }
    //在指定索引处添加数据
    public void add(int index,T t){
        if(size>=data.length) {
           resize(2*data.length);
        }
        else if (index<0||index>data.length){
            throw new IllegalArgumentException("索引值出错");
        }
        else{
            //从指定索引处开始向后移
            for(int j=size; j>index;j--){
                data[j]=data[j-1];
            }
            data[index]=t;
            size++;
        }
    }
    /**
     * 根据索引进行删除数据,并且返回该元素
     * @param index
     * @return
     */
    public T remove(int index) {
        if(size==data.length/2)
            resize(data.length*2/3);
        if(index>=0&&index<size) {
            T temp=data[index];
            for (int j = index; j < size; j++) {
                data[j] = data[j + 1];
            }
            size--;
            data[size]=null;
            return temp;
        }else
            return null;
    }
    public T removeFrist()
    {
        return remove(0);
    }
    public T removeLast()
    {
        return remove(size-1);
    }
    public boolean removeElement(T t){
        int index=contains(t);
        if(index!=-1)
        {
            remove(index);
            return true;
        }
        return false;
    }
    /**
     * <dl>
     *     <dt>检查数组是否为空</dt>
     * </dl>
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }
    //在数组中查询元素是否存在
    public boolean isHave(T t)
    {
        int flag=contains(t);
        if(flag==-1)
            return false;
        else
            return true;
    }
    //在数组中查询元素并返回索引值
    public int contains(T t)
    {
        for(int i=0;i<size;i++)
        {
            if(t.equals(data[i]))
            {
                return i;
            }
        }
        return -1;
    }
    //修改元素
    public boolean set(int index,T t)
    {
        if(index<0||index>data.length)
        {
            System.out.println("索引值错误");
            return false;
        }else{
            data[index]=t;
            return true;
        }
    }
    //将t1覆盖为t
    public boolean update(T t,T t1)
    {
        int index=contains(t);
        if(index==-1)
            return false;
        else
            data[index]=t1;
        return true;
    }

    //覆盖toString方法
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++)
        {
            sb.append(data[i].toString());
            if(i!=size-1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
    public T get(int index)
    {
        if(index<0||index<size)
            throw new IllegalArgumentException("获取失败");
        return data[index];
    }
    //对数组进行容量变化,实现动态数组
    private void resize(int newCapacity)
    {
        T[] newData=(T[])new Object[newCapacity];
        for(int i=0;i<size;i++)
            newData[i]=data[i];
        data=newData;
    }
}
