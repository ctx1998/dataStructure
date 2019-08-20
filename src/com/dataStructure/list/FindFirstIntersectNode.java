package com.dataStructure.list;

import java.util.HashSet;

/**
 * 如果两个链表相交，返回第一个相交的结点
 *    1.判断两个链表是否有环
 *    2.两个无环链表的相交问题
 *    3.两个有环链表的相交问题
 *    4.一个有环一个无环链表的相交问题
 */
public class FindFirstIntersectNode {
    //判断是否有环如果有环返回第一个入环的结点
    public static class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    //判断是否有环，使用HashSet遍历的时候判断是否HashSet当中有该结点
    public static Node isRing1(Node head){
        if(head==null||head.next==null)//一个结点是无法构成环的
            return null;
        HashSet<Node> hashSet=new HashSet<Node>();
        Node cur=head;
        while(cur!=null)
        {
            if(hashSet.contains(cur))
                return cur;//第一个入环结点
            else
            {
                hashSet.add(cur);
                cur=cur.next;
            }
        }
        return null;
    }
    //判断是否有环，使用快指针和慢指针的思想,快指针和慢指针第一次相遇时，快指针返回到开头处，快指针一次走一步，再次相遇
    //为入环处，如果慢指针一圈走完了，快指针与慢指针仍没有相遇说明没有环
    public static Node isRing2(Node head){
        if(head==null||head.next==null)
            return null;
        Node fast=head;
        Node slow=head;
        boolean isFlag=false;//标识符，用来判断慢指针与快指针是否相遇过
        //遍历是要先判断快指针是否还能走两步
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) {
                isFlag=true;
                break;
            }
        }
        if(!isFlag)
            return null;
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
    //两个无环链表使用hashSet用于检验head2中是否包含head1的结点
    public static Node bothNoRing(Node head1,Node head2){
        if(head1==null||head2==null)
            return null;
        //将链表1全部入hashSet中
        Node cur=head1;
        HashSet<Node> hashSet=new HashSet<Node>();
        while(cur!=null){
            hashSet.add(cur);
            cur=cur.next;
        }
        //遍历链表2查看是否链表2中含有链表1的元素
        cur=head2;
        while(cur!=null){
            if(hashSet.contains(cur))
                return cur;
            cur=cur.next;
        }
        return null;
    }
    //两个无环链表的相交问题，不使用HashSet如果相交一定最后一个结点内存地址相同
    public static Node bothNoRing1(Node head1,Node head2){
        //得到链表1的长度以及链表1最后一个结点
        Node cur=head1;
        Node end1;
        int count=0;
        while(cur.next!=null){
            cur=cur.next;
            count++;
        }
        count++;
        end1=cur;
        //得到链表2的长度以及链表2最后一个结点
        Node end2;
        int count2=0;
        cur=head2;
        while(cur.next!=null){
            cur=cur.next;
            count2++;
        }
        count2++;
        end2=cur;
        return bothNo(head1,head2,end1,end2,count,count2);
    }
    //一个有环一个无环必定没有相交的结点
    public static Node haveOneRing(Node head1,Node head2){
        return null;
    }
    public static Node bothNo(Node head1,Node head2,Node end1,Node end2,int count1,int count2){
        //哪个长哪个先多走几步
        int distance=0;
        Node cur;
        Node cur1=null;
        if(count1>count2)
        {
            cur1=head2;
            cur=head1;
            distance=count1-count2;
        }
        else if(count1<count2){
            cur1=head1;
            cur=head2;
            distance=count2-count1;
        }else
        {
            cur=head1;
            cur1=head2;
        }
        while(distance>0){
            cur=cur.next;
            distance--;
        }
        //两个同时走
        while(cur!=null||cur1!=null){
            if(cur==cur1)
                return cur;
            cur=cur.next;
            cur1=cur1.next;
        }
        return null;
    }
    /*
        两个都有环(与入环结点相同)
            1. 各自成环
            2. 先相交后成环
            3. 在环上有相交的结点
     */
    public static Node bothRing(Node head1,Node head2){
        Node cur=isRing1(head1);
        Node cur1=isRing2(head2);
        //第二种情况，入环以前可以看成是无环链表
        if(cur==cur1){
            Node cur2=head1;
            Node cur3=head2;
            int count=0;
            int count1=0;
            //得到链表1没有入环的最后一个结点以及长度1
            while(cur2.next!=cur){
                   cur2=cur2.next;
                   count++;
            }
            while(cur3.next!=cur1){
                cur3=cur3.next;
                count1++;
            }
            cur2=cur2.next;
            count++;
            cur3=cur3.next;
            count1++;
            return bothNo(head1,head2,cur1,cur2,count,count1);
        }
        //不相等,就要看是各自成环还是在环上有相交的结点
        //各自成环，即链表1的入环处逐步next碰不到链表2的入环处
        Node cur2=cur;
        Boolean isFlag=false;
        while(cur2!=null){
            if(cur2==cur1){
                isFlag=true;
                break;
            }
            cur2=cur2.next;
        }
        //如果isFlag为false各自成环无相交点,为true有相交点
        if(isFlag==false)
            return null;
        else
            return cur;
    }
    public static Node twoList(Node head1,Node head2){
        //给了两个链表判断
        Node cur=isRing1(head1);
        Node cur1=isRing2(head2);
        //两个都有环
        if(cur!=null&&cur1!=null)
            return bothRing(head1,head2);
        //两个都没有环
        else if(cur==null&&cur1==null)
            return  bothNoRing1(head1,head2);
        else
            return haveOneRing(head1,head2);
    }
    public static void main(String[] args){
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        System.out.println(twoList(head1, head2).value);

      // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        twoList(head1, head2);
        System.out.println(twoList(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        twoList(head1, head2);
        System.out.println(twoList(head1, head2).value);
    }
}
