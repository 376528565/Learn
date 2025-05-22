package com.thread.juc.collections;

/**
 * @Author: LQL
 * @Date: 2024/07/12
 * @Description:
 */
public class ConcurrentLinkedQueue_7<E> {


    /**
     * Q:
     * 要想用线程安全的队列有哪些选择?
     * Vector，Collections.synchronizedList(List<T> list), ConcurrentLinkedQueue等
     *
     * ConcurrentLinkedQueue实现的数据结构?
     * 链表
     *
     * ConcurrentLinkedQueue底层原理? 全程无锁(CAS)
     * 通过Unsafe的cas方法实现
     *
     * ConcurrentLinkedQueue的核心方法有哪些?
     * offer()，poll()，peek()，isEmpty()等队列常用方法
     *
     * 说说ConcurrentLinkedQueue的HOPS(延迟更新的策略)的设计?
     * tail更新触发时机：
     * 当tail指向的节点的下一个节点不为null的时候，会执行定位队列真正的队尾节点的操作，
     * 找到队尾节点后完成插入之后才会通过casTail进行tail更新；当tail指向的节点的下一个节点为null的时候，只插入节点不更新tail
     * head更新触发时机：
     * 当head指向的节点的item域为null的时候，会执行定位队列真正的队头节点的操作，
     * 找到队头节点后完成删除之后才会通过updateHead进行head更新；
     * 当head指向的节点的item域不为null的时候，只删除节点不更新head。
     *
     * 如果让tail永远作为队列的队尾节点，实现的代码量会更少，而且逻辑更易懂。
     * 但是，这样做有一个缺点，如果大量的入队操作，每次都要执行CAS进行tail的更新，
     * 汇总起来对性能也会是大大的损耗。如果能减少CAS更新的操作，无疑可以大大提升入队的操作效率
     * 虽然，这样设计会多出在循环中定位队尾节点，但总体来说读的操作效率要远远高于写的性能，
     * 因此，多出来的在循环中定位尾节点的操作的性能损耗相对而言是很小的
     *
     * ConcurrentLinkedQueue适合什么样的使用场景?
     * 1、多线程并发时使用无锁条件：我们自己使用无锁的条件的话，这个队列是个不错的参考
     * ConcurrentLinkedQueue通过无锁来做到了更高的并发量，是个高性能的队列，
     * 但是使用场景相对不如阻塞队列（blockingQueue）常见，毕竟取数据也要不停的去循环，不如阻塞的逻辑好设计，
     * 2、但是在并发量特别大的情况下，是个不错的选择，性能上好很多
     */

    public static void main(String[] args) {
        ConcurrentLinkedQueue_7 linkedQueue7 = new ConcurrentLinkedQueue_7();
        linkedQueue7.fun1();
    }

    public void fun1(){
        System.out.println(this);
    }
}
