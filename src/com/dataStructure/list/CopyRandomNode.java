package com.dataStructure.list;

import java.util.HashMap;

public class CopyRandomNode {
    public static class Node{
        Node next;
        Node random;
        int value;
        public Node(int value)
        {
            this.value=value;
        }
    }
    public static Node copyByHashMap(Node n)
    {
        if(n==null)
            return null;
        //将结点以及结点的拷贝结点放入HashMap当中
        HashMap<Node,Node> hashMap=new HashMap<Node,Node>();
        Node cur=n;
        while(cur!=null)
        {
            Node copyN=new Node(cur.value);
            hashMap.put(cur,copyN);
            cur=cur.next;
        }
        //遍历链表，连接拷贝结点的next和random结点
        cur=n;
        while(cur!=null)
        {
            hashMap.get(cur).next=hashMap.get(cur.next);
            hashMap.get(cur).random=hashMap.get(cur.random);
            cur=cur.next;
        }
        return hashMap.get(n);
    }
    public static void printRandLinkedList(Node head) {

        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static Node copyRandom(Node head){
        if(head==null)
            return null;
        //遍历结点，更改next为拷贝
        Node cur=head;
        while(cur!=null){
            Node copyNode=new Node(cur.value);
            Node next=cur.next;
            cur.next=copyNode;
            copyNode.next=next;
            cur=cur.next.next;
        }
        //拷贝随机链表
        cur=head;
        while(cur!=null){
            cur.next.random=cur.random!=null?cur.random.next:null;
            cur=cur.next.next;
        }
        //将大链表拆分成小链表
        cur=head;
        Node res=head.next;
        Node next;
        Node curCopy;
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyByHashMap(head);
        printRandLinkedList(res1);
        res2 = copyRandom(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyByHashMap(head);
        printRandLinkedList(res1);

        res2 = copyRandom(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
