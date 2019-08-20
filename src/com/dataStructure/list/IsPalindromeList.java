package com.dataStructure.list;

import java.util.Stack;

/*判断一个链表是否是回文结构*/
public class IsPalindromeList {
    //使用栈，遍历链表的过程中，让其入栈，再重头遍历与出栈的内容进行相比
    public static boolean isPalindremeList1(Node n){
        Stack<Integer> stack=new Stack<Integer>();
        Node cur=n;
        while(cur!=null){
            stack.push(cur.value);
            cur=cur.next;
        }
        //遍历
        while(n!=null){
            if(n.value!=stack.pop())
                return false;
            n=n.next;
        }
        return  true;
    }
    public static boolean isPalindremeList2(Node n){
        Node slow=n;
        Node fast=n;
        if(n==null||n.next==null)
            return true;
        slow=slow.next;
        while(fast.next!=null &&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Stack<Integer> stack=new Stack<Integer>();
        while(slow!=null){
            stack.push(slow.value);
            slow=slow.next;
        }
        while (!stack.isEmpty()){
            if(n.value!=stack.pop())
                return false;
            n=n.next;
        }
        return true;
    }
    public static boolean isPalindremeList3(Node n){
        if(n==null||n.next==null)
            return true;
        Node slow=n;
        Node fast=n;
        Boolean flag=true;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //在偶数个的时候，fast的next不为null
        if(fast.next!=null)
            fast=fast.next;
        System.out.println(slow.value+"====="+fast.value);

        //从fast为头结点开始反转链表
        Node prev=null;
        Node next;
        Node rig=fast;
        Node left=n;
        while(slow!=null)
        {
            next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        //两边开始走
        while(left!=null&&rig!=null){
            System.out.println(left.value+"===="+rig.value);
            if(left.value!=rig.value) {
                flag = false;
                break;
            }
            left=left.next;
            rig=rig.next;
        }
        //将链表返回到原来的样子，再次进行链表反转
        prev=null;
        next=fast.next;
        while(fast!=null)
        {
            next=fast.next;
            fast.next=prev;
            prev=fast;
            fast=next;

        }
        return flag;
    }
    public static void printList(Node n){
        while(n!=null){
            System.out.print(n.value+"  ");
            n=n.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        boolean flag1,flag2,flag3;
        Node n=new Node(1);
        n.next=new Node(2);
        n.next.next=new Node(3);
        n.next.next.next=new Node(1);
        flag1=isPalindremeList1(n);
        flag2=isPalindremeList2(n);
        flag3=isPalindremeList3(n);
        printList(n);
        System.out.println(flag1+"===="+flag2+"===="+flag3);
    }
}
