package com.thread.juc.lock;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Author: LQL
 * @Date: 2024/06/17
 * @Description:
 */
public class JucAtomicClass {


//    ReentrantLock

    /**
     * JUC中多数类是通过volatile和CAS来实现的，CAS本质上提供的是一种无锁方案，
     * 而Synchronized和Lock是互斥锁方案; java原子类本质上使用的是CAS，而CAS底层是通过Unsafe类实现的。
     * 所以本章将对CAS, Unsafe和原子类详解
     */

    /**
     * 线程安全的实现方法有哪些?
     * A;1、互斥同步（synchronized,lock）2、非阻塞同步（乐观锁 CAS 3、无锁-访问的是非共享资源时
     * 什么是CAS?
     * A；CAS 比较替换原则，乐观锁实现（相信sql大家都熟悉，类似sql中的条件更新一样：
     * update set id=3 from table where id=2。因为单条sql执行具有原子性，
     * 如果有多个线程同时执行此sql语句，只有一条能更新成功
     * -------------------------
     * CAS使用示例，结合AtomicInteger给出示例?
     * CAS是指：将变量地址的值跟预期值比较是否相等，相等则替换，反之则会循环比较直到相等
     * AtomicInteger的addAndGet(1)方式底层通过CAS实现乐观锁的方式，不然就要通过synchronized实现互斥同步，lock底层也是通过cas实现
     * CAS会有哪些问题?
     * 1、ABA问题：
     * ABA问题的解决思路就是使用版本号。在变量前面追加上版本号，每次变量更新的时候把版本号加1，那么A->B->A就会变成1A->2B->3A
     * 2、自旋时间长开销大：在cas失败后会进行自旋比较直到成功，处理器提供的pause指令可以延迟流水线执行命令
     * 3、只能保证单个共享变量的原子操作，多变量时可以通过AtomicReference实现将变量合并到一个对象中处理
     * -----------------
     * 针对这这些问题，Java提供了哪几个解决的?
     * A；ABA问题的解决思路就是使用版本号，自旋时间长开销大引入pause指令延迟命令执行，多变量时可以通过AtomicReference实现将变量合并到一个对象中处理
     * AtomicInteger底层实现?
     * 通过调用CPU级别的CAS实现多线程对共享数据的操作
     * ----------------
     * CAS+volatile请阐述你对Unsafe类的理解?
     * Unsafe类：提供一些用于执行低级别、不安全操作的方法，如直接访问系统内存资源、自主管理内存资源等
     * Unsafe提供的API大致可分为内存操作、CAS、Class相关、对象操作、线程调度、系统信息获取、内存屏障、数组操作等几类
     * volatile保证线程的可见性，多线程并发时，一个线程修改数据，可以保证其它线程立马看到修改后的值
     * CAS 保证数据更新的原子性
     * ------------------
     * 说说你对Java原子类的理解? 包含13个，4组分类，说说作用和使用场景。
     * 1、原子更新基本类型：AtomicBoolean/Integer/Long
     * 2、原子更新数组:AtomicIntegerArray/LongArray/ReferenceArray(更新引用类型数组中的元素)
     * 3、原子更新引用类型:AtomicReference/StampedReference/MarkableReferce(原子更新带有标记位的引用类型)
     * 4、原子更新字段类：AtomicIntegerFieldUpdater/LongFieldUpdater/ReferenceFieldUpdater，更新的字段需是public volatile修饰的
     * AtomicStampedReference是什么?
     * 原子更新引用类型
     * AtomicStampedReference是怎么解决ABA的?
     * 内部使用Pair来存储元素值及其版本号java中还有哪些类可以解决ABA的问题? AtomicMarkableReference
     */

    public static void main(String[] args) {

    }

}
