package com.thread.juc.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @Author: LQL
 * @Date: 2024/07/12
 * @Description:
 */
public class CopyOnWriteArrayList_6 {


    /**
     * CopyOnWriteArrayList是ArrayList 的一个线程安全的变体，
     * 其中所有可变操作(add、set 等等)都是通过对底层数组进行一次新的拷贝来实现的。COW模式的体现
     *
     * 问题：
     * 请先说说非并发集合中Fail-fast机制?
     * 通过迭代器对集合中的数据进行增删操作时，会导致modconut值（操作计数器）跟默认的不同触发异常造成fail-fast
     *
     * 再为什么说ArrayList查询快而增删慢?
     * 内部的数据结构是数组，数组在内存中连续存储，因此查询快，增删慢
     *
     * 对比ArrayList说说CopyOnWriteArrayList的增删改查实现原理? COW基于拷贝
     * ArrayList的增删改查直接操作数组，添加就扩容，删除就减小，
     * 而COWArrayList是并发集合，因此增删改根据写时拷贝实现，底层是调用System的arrayCopy的native方法，
     * 通过新产生的数组替换原来的数组实现增删改，读的话支持多线程并发读
     *
     * 再说下弱一致性的迭代器原理是怎么样的?
     * 在COWArrayList中COWIterate-弱一致性（最终一致性）的迭代器只支持读，任何增删改操作都会导致报错，
     * 内部通过快照数组来存储当前并发集合的数据实现多线程并发访问
     *
     * COWIterator<E>CopyOnWriteArrayList为什么并发安全且性能比Vector好?
     * CopyOnWriteArrayList 在增删改操作时使用写时复制和细粒度锁，实现了线程安全，
     * 同时不影响读操作的并发执行，性能优于 Vector。
     * Vector 由于所有操作都使用 synchronized 进行同步，导致同一时刻只能有一个线程进行操作，容易成为性能瓶颈
     *
     * CopyOnWriteArrayList有何缺陷，说说其应用场景?
     * 多线程并发时适用多读少写的情况，只能保证最终一致性，如果并发时写多会导致读取的数据不一致。
     * 多使用在读多写少的情况下，例如存储程序的配置信息，供程序中多线程读取
     */


    public static void main(String[] args) {
//        非并发集合的快速失败机制-fast-fail,通过modcount操作计数器的数字进行比较
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
            list.add(2);
        }
        System.out.println(list);

//        COWArrayList实现


    }

}
