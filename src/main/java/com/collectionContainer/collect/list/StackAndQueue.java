package com.collectionContainer.collect.list;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author: LQL
 * @Date: 2024/12/16
 * @Description:
 */
public class StackAndQueue implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient int size;

    /**
     * java中存在Stack类，Queue接口，在使用栈、队列时不推荐使用Stack推荐使用ArrayDequeue(环形数组)
     *  原因：
     *  Stack 是遗留类，过时且设计不够现代化（内部实现是通过Vector-线程安全锁方法）
     *  Stack 的线程安全机制在多数场景下不必要，增加了性能开销。
     *  ArrayDeque 是轻量级、高性能、灵活的栈和队列实现。
     *  Java 官方文档明确推荐使用 Deque 接口及其实现（如 ArrayDeque）
     *
     * 如果要考虑线程安全可以通过
     * 使用 Collections.synchronizedList 来间接实现，
     * 或者直接使用 ConcurrentLinkedDeque（线程安全的双端队列）--链表实现的无锁多线程并发方案，
     * 内部通过将节点定义成volatile确保多线程下数据的内存可见性，以及UNSAFE的CAS方法实现数据的修改
     */

    public static void main(String[] args) {

        StackAndQueue stackAndQueue = new StackAndQueue();
        stackAndQueue.size = 10;

        Stack<Object> stack = new Stack<>();

        List<Object> arrayDeque = new LinkedList<>();
        /**
         * synchronizedList通过锁集合实现原始对象的方法:
         *          final Collection<E> c;  // Backing Collection
         *         final Object mutex;     // 具体实例对象，通过在增删改查方法中锁该对象实现对原始集合的加锁
         *
         *         SynchronizedCollection(Collection<E> c) {
         *             this.c = Objects.requireNonNull(c);
         *             mutex = this;
         *         }
         *         具体方法
         *          public boolean add(E e) {
         *             synchronized (mutex) {return c.add(e);}
         *         }
         */
        Collections.synchronizedList(arrayDeque);

        ConcurrentLinkedDeque<Object> objects = new ConcurrentLinkedDeque<>();

        stackAndQueue.func1(6);

    }

    public void func1(int index){
        if (index > size >> 1){
            System.out.println("index > " + (size >> 1));
        }else {

        }
    }

}
