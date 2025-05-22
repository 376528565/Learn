package com.thread.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2024/06/24
 * @Description:
 */
public class ReentrantLock_3 {

    private Lock lock = new ReentrantLock();

    /**
     * 可重入锁ReentrantLock的底层是通过AbstractQueuedSynchronizer-AQS实现
     * Q:
     * 什么是可重入，什么是可重入锁? 它用来解决什么问题?
     *  可重入：函数在被调用期间可以再次被调用，并且可以按照逻辑正常执行完成
     *  可重入锁：一个线程可以对已经获取锁的共享资源再次上锁
     *  解决问题：多线程环境下，可以安全的通过递归或者嵌套方法实现功能
     *
     * ReentrantLock的核心是AQS，那么它怎么来实现的，继承吗?
     * 内部抽象类sync继承AQS重写AQS中isHeldExclusively、tryRelease等方法实现
     *
     * 说说其类内部结构关系。ReentrantLock是如何实现公平锁的?
     * 内部抽象类Sync继承AQS，类中包含公平锁和非公平锁的实现类，继承Sync
     * 在实例化时通过传入ture参数实现公平锁
     *
     * ReentrantLock是如何实现非公平锁的?
     * 继承关系：NonfairSync继承自Sync，而Sync继承自AbstractQueuedSynchronizer（AQS）。
     * 快速尝试获取锁：在NonfairSync的lock方法中，通过CAS操作快速尝试获取锁。
     * 非公平获取锁逻辑：在nonfairTryAcquire方法中，首先尝试通过CAS操作获取锁，
     * 如果锁未被占用，则成功获取锁；如果锁已被占用且是当前线程，则增加重入计数；
     * 否则，将当前线程加入到同步队列中。
     * AQS队列机制：如果初次尝试获取锁失败，线程将被加入到AQS的同步队列中等待，直到锁可用
     *
     * ReentrantLock默认实现的是公平还是非公平锁?
     * 非公平
     *
     * 使用ReentrantLock实现公平和非公平锁的示例?
     * 在实例化时指定参数为true时公平锁，反之为非公平
     *
     * ReentrantLock和Synchronized的对比?
     * 控制粒度：
     * ReentrantLock提供了更细粒度的锁控制，可以在代码的任何地方显式地加锁和解锁。
     * synchronized通过方法或代码块进行隐式加锁和解锁，控制粒度较粗。
     * 锁的获取和释放：
     * ReentrantLock需要显式地调用lock()和unlock()方法来加锁和解锁。
     * synchronized由JVM自动管理锁的获取和释放，不需要显式地解锁。
     * 线程调度：
     * ReentrantLock支持公平锁，按照线程等待的顺序获取锁，避免饥饿现象。
     * synchronized不支持公平锁，线程获取锁的顺序是不可预知的。
     * 线程中断：
     * ReentrantLock支持可中断的锁获取，可以在等待锁的过程中响应中断。
     * synchronized不支持可中断的锁获取，线程在等待锁时不能被中断。
     * 条件变量：
     * ReentrantLock支持多个条件变量，可以实现复杂的等待/通知机制。
     * synchronized只有一个条件变量，通过wait()、notify()和notifyAll()方法实现线程间通信
     */


}
