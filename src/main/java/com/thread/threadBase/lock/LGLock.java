package com.thread.threadBase.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2024/06/13
 * @Description: 乐观锁
 */
public class LGLock {

    /**
     * 乐观锁与悲观锁是一种广义上的概念，体现了看待线程同步的不同角度。在Java和数据库中都有此概念对应的实际应用。
     *
     * 悲观锁适合写操作多的场景，先加锁可以保证写操作时数据正确。
     * 乐观锁适合读操作多的场景，不加锁的特点能够使其读操作的性能大幅提升
     */

//    -----------乐观锁-------------
//    AtomicInteger是乐观锁实现的，通过版本号和CAS原则实现
    private AtomicInteger atomicInteger = new AtomicInteger();//需要保证多个线程使用的是同一个AtomicInteger
    public void lgFun1(){
        atomicInteger.incrementAndGet();//执行自增1
    }


//    ------------悲观锁-------------
    public synchronized void fun1(){}
    private Lock lock = new ReentrantLock();
    public void lockFunc(){
        lock.lock();
        try {
            //deal
        }finally {
            lock.unlock();
        }
    }

}
