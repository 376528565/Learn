package com.thread.juc.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: LQL
 * @Date: 2024/06/20
 * @Description:
 */
public class AbstractQueuedSynchronizerAQS_2 {


    /**
     * AbstractQueuedSynchronizer抽象类是核心，需要重点掌握。
     * 它提供了一个基于FIFO队列，可以用于构建锁或者其他相关同步装置的基础框架
     *
     * AQS是一个用来构建锁和同步器的框架，使用AQS能简单且高效地构造出应用广泛的大量的同步器，
     * 比如我们提到的ReentrantLock，Semaphore，
     * 其他的诸如ReentrantReadWriteLock，SynchronousQueue，FutureTask等等皆是基于AQS的。
     * 当然，我们自己也能利用AQS非常轻松容易地构造出符合我们自己需求的同步器
     * ------
     * 著作权归@pdai所有
     * 原文链接：https://pdai.tech/md/java/thread/java-thread-x-lock-AbstractQueuedSynchronizer.html
     *
     *
     * 问题：
     * 1、AbstractQueuedSynchronizer（AQS）为什么是锁的核心类？
     * 为构建锁和同步器提供了一个通用基础（模板方法模式），通过管理状态和线程队列实现高效的同步.
     * 锁和同步器区别？
     * 锁：主要用于独占访问共享资源，保证同一时刻只有一个线程可以访问资源。
     * 同步器：更高级的控制机制，不仅包含锁的功能，还支持多线程协作、计数、信号、屏障等复杂的并发控制
     *2、AQS的核心思想是什么? 它是怎么实现的? 底层数据结构等
     * 核心思想：
     * 如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并且将共享资源设置为锁定状态。
     * 如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及被唤醒时锁分配的机制，
     * 这个机制AQS是用CLH队列锁实现的，即将暂时获取不到锁的线程加入到队列中
     *
     */


    public class A extends AbstractQueuedSynchronizer{

    }

}
