package com.collectionContainer.collect.list;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @Author: LQL
 * @Date: 2024/12/13
 * @Description:
 */
public class LinkedListClass<E> {


    private Node<E> first;
    private Node<E> last;

    /**
     * LinkedList实现Deque和List接口，顺序存储集合，双向链表。既可以作为队列也可以作为栈使用（先进先出或者后出）
     * 关于栈或队列，现在的首选是ArrayDeque，它有着比LinkedList(当作栈或队列使用时)有着更好的性能-通过环形队列实现
     *
     * LinkedList的实现方式决定了所有跟下标相关的操作都是线性时间，而在首段或者末尾删除元素只需要常数时间
     * 为追求效率LinkedList没有实现同步(synchronized)，如果需要多个线程并发访问，
     * 可以先采用Collections.synchronizedList()方法对其进行包装
     *
     * LinkedList实现Deque接口（继承queue接口），可作为双向队列使用，提供操作队头、队尾元素方法
     */


    public static void main(String[] args) {


        LinkedList<String> objects = new LinkedList<>();
        System.out.println(Integer.MAX_VALUE);
        objects.get(2);
//        ArrayDeque<String> objects = new ArrayDeque<>();
        System.out.println(15 << 1);
        LinkedListClass<String> stringLinkedListClass = new LinkedListClass<>();
        stringLinkedListClass.deal(stringLinkedListClass);
    }

    public void deal(LinkedListClass<String> stringLinkedListClass) {
        stringLinkedListClass.linkLast("alen");
        stringLinkedListClass.linkLast("bella");
        Node<String> p = (Node<String>) stringLinkedListClass.first;
        while(p != null){
            System.out.println(p.e);
            p = p.next;
        }
    }

    public void linkFirst(E e){
        Node<E> f = first;
        Node<E> eNode = new Node<>(null, e, f);
        first = eNode;
        if (f == null)
            last = eNode;
        else
            f.pre = eNode;
    }

    public void linkLast(E e){
        Node<E> l = last;
        Node<E> eNode = new Node<>(l, e, null);
        last = eNode;
        if (l == null)
            first = eNode;
        else
            l.next = eNode;
    }


    class Node<E> {
        private Node<E> pre;
        private E e;
        private Node<E> next;

        public Node(Node pre,E e,Node next){
            this.pre = pre;
            this.e = e;
            this.next = next;
        }
    }

}
