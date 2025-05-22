package com.thread.juc.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: LQL
 * @Date: 2024/07/08
 * @Description:
 */
public class ConcurrentHashMap_5 {

    /**
     * JDK1.7之前的ConcurrentHashMap使用分段锁机制实现，
     * JDK1.8则使用数组+链表+红黑树数据结构和CAS原子操作实现ConcurrentHashMap
     * Q:
     * 为什么HashTable慢? 它的并发度是什么? 那么ConcurrentHashMap并发度是什么?
     * A:因为hashtable对于put、get等操作采用同步锁的方式sychronized，导致只有单线程获取对象锁，所以慢。
     * 并发度1，concurrentHashmap的并发度根据JDK版本，1.7以及之前为16，之后根据集合数组容量确定
     *
     * ConcurrentHashMap在JDK1.7和JDK1.8中实现有什么差别? JDK1.8解決了JDK1.7中什么问题
     * A:实现差别主要体现在内部数据结构上，1.7使用的是分段式锁，将集合默认分为16个segment对每个segment的数据操作上锁处理，
     * 而1.8是通过数组、链表、红黑树以及Unsafe的CAS方法实现的。
     * 1.8解决1.7的数组扩容，并优化了数据查询速度（红黑树）。
     *
     * ConcurrentHashMap JDK1.7实现的原理是什么? 分段锁机制
     * A:分段锁机制，内部数据结构是segment数组，通过对每个segment对象添加锁的方式实现多线程并发访问
     *
     * ConcurrentHashMap JDK1.8实现的原理是什么? 数组+链表+红黑树，CAS
     * A：数组、链表、红黑树的数据结构，根据Node添加锁，实现多线程并发访问
     *
     * ConcurrentHashMap JDK1.7中Segment数(concurrencyLevel)默认值是多少? 为何一旦初始化就不可再扩容?
     * A：16，设计就是如此，在初始化segment数组后就会以此为基础进行并发控制
     * 在1.8时就concurrentHashMap就支持动态扩容
     *
     * ConcurrentHashMap JDK1.7说说其put的机制?
     * A：
     *
     * ConcurrentHashMap JDK1.7是如何扩容的? rehash(注：segment 数组不能扩容，扩容是 segment 数组某个位置内部的数组 HashEntry<K,V>[] 进行扩容)
     *
     *
     * ConcurrentHashMap JDK1.8是如何扩容的? tryPresize
     * ConcurrentHashMap JDK1.8链表转红黑树的时机是什么? 临界值为什么是8?
     * 8时转为红黑树效率最好，既不会因为数据较少在转换时增加转换开销，也不会过大影响查询性能
     * ConcurrentHashMap JDK1.8是如何进行数据迁移的? transfer
     *
     *
     */


    public static void main(String[] args) {
        int  i = 1 << 30;
        System.out.println(i);
    }

}
