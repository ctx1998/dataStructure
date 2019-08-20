package com.dataStructure.list;
/**
 * 将单向链表划分成左边小中间相等右边大的形式(荷兰国旗)
 */
public class SmallerEqualBigger {
    public static class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    //使用数组的方式，空间复杂度O(N)
    public static Node divideArrayList(Node head,int target){
        Node cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        Node[] array=new Node[count];
        //遍历链表，将链表的内容放置在数组当中
        cur=head;
        for(int i=0;i<count;i++){
            array[i]=cur;
            cur=cur.next;
        }

        divideArray(array,target);
        for(Node n:array){
            System.out.print(n.value+"  ");
        }
        System.out.println();
        //将数组变为链表，增添next属性
        int i;
        for(i=1;i<array.length;i++)
        {
            array[i-1].next=array[i];
        }
        array[i-1].next=null;
        return array[0];
    }
    //数组问题解决荷兰国旗
    public static void divideArray(Node[] array,int target){
          int less=-1;
          int more=array.length;
          int i=0;
          while(i!=more){
              if(array[i].value>target)
              {
                  swap(array,i,--more);
              }
              else if(array[i].value<target){

                  swap(array,i++,++less);
              }
              else
                  i++;
          }

    }
    public static void swap(Node[] arr,int i,int j){
        Node temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static Node devideList(Node head,int target){
        //弄有限个变量实现
        Node less=null;//小于区
        Node equal=null;//等于区
        Node more=null;//大于区
        Node cur=head;
        //在第一次遍历中找到第一个小于第一个等于第一个大于的结点头结点
        while(cur!=null){
            if(less==null&&cur.value<target)
                less=cur;
            else if(equal==null&&cur.value==target)
                equal=cur;
            else if(more==null&&cur.value>target)
                more=cur;
            cur=cur.next;
            if(less!=null && equal!=null&&more!=null)
                break;
        }
        cur=head;
        Node endLess=less;
        Node endEqual=equal;
        Node endMore=more;
        while(cur!=null){
            if(cur.value<target&&cur!=less){
                endLess.next=cur;
                endLess=endLess.next;
            }
            else if(cur.value==target&&cur!=equal){
                endEqual.next=cur;
                endEqual=endEqual.next;
            }else if(cur.value>target &&cur!=more){
                endMore.next=cur;
                endMore=endMore.next;
            }
            cur=cur.next;
        }
        //将划分的小于区链表等于区链表大于区链表合并
       if(less!=null) {
           endLess.next = equal != null ? equal : more;
           if(equal==null&&more!=null)
               endMore.next=null;
       }
        if(equal!=null) {
            endEqual.next = more;
            if(more !=null)
                endMore.next=null;
        }
        return less!=null?less:equal!=null?equal:more;

    }
    public static void printList(Node head){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.value+"   ");
            cur=cur.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printList(head1);
      //  Node head2 = divideArrayList(head1, 4);
        //printList(head2);
        Node head3 = devideList(head1, 5);
        printList(head3);
    }
}
