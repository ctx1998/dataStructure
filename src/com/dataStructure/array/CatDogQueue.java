package com.dataStructure.array;

import java.util.LinkedList;
import java.util.Queue;

class Pet {
    private String type;
    public Pet(String type) {
        this.type = type;
    }
    public String getPetType() {
        return this.type;
    }
}
class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}
class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}
class petEnterQueue{
    private Pet pet;
    private Long count;
    public petEnterQueue(Pet pet,Long count){
        this.pet=pet;
        this.count=count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
/*实现一种狗猫队列的结构，要求如下：
用户可以调用add方法将cat类或dog类的 实例放入队列中
用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出
用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
用户可以调用pollCat方法，将队列中cat类的实 例按照进队列的先后顺序依次弹出
用户可以调用isEmpty方法，检查队列中是 否还有dog或cat的实例
用户可以调用isDogEmpty方法，检查队列中是否有dog 类的实例
用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
 */
public class CatDogQueue {
    private Queue<petEnterQueue> queueDog;//狗队列
    private Queue<petEnterQueue> queueCat;//猫队列
    private Long count;//计数器
    public CatDogQueue()
    {
        queueDog = new LinkedList<petEnterQueue>();
        queueCat = new LinkedList<petEnterQueue>();
        count = 0L;
    }
    public void add(Pet pet){
        //得到宠物的类型，判断进哪个队列
        if("dog".equals(pet.getPetType())) {
            queueDog.add(new petEnterQueue(pet,count++));
        }else if("cat".equals(pet.getPetType())){
            queueCat.add(new petEnterQueue(pet,count++));
        }else
            throw  new RuntimeException("err ,not dog or cat");
    }
    public Pet pollAll(){
        //拿到狗队列的出队元素以及猫队列的出队元素，判断哪个的count小
        if(!queueDog.isEmpty() && !queueCat.isEmpty())
        {
            if (queueCat.peek().getCount()<queueDog.peek().getCount())
                return queueCat.poll().getPet();
            else
                return queueDog.poll().getPet();
        }
        //如果只有一个队列有元素，返回那个队列的对头
        else if(!queueDog.isEmpty()){
            return queueDog.poll().getPet();
        }else if(!queueCat.isEmpty()){
            return queueCat.poll().getPet();
        }else
           throw new RuntimeException("err,queue is empty");
    }
    public Dog pullDog(){
        if (!queueDog.isEmpty()){
            return (Dog) queueDog.poll().getPet();
        }
        else
        throw new RuntimeException("Dog queue is empty!");
    }
    public Cat pullCat(){
        if(!queueCat.isEmpty()){
            return (Cat) queueCat.poll().getPet();
        }else
            throw new RuntimeException("Cat Queue is empty");
    }
    public boolean isEmpty() {
        if(queueCat.isEmpty()&&queueDog.isEmpty())
            return true;
        else
            return false;
    }
    public boolean isDogEmpty(){
        return queueDog.isEmpty();
    }
    public boolean isCatEmpty(){
        return queueCat.isEmpty();
    }
    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

       Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

       test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pullDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
