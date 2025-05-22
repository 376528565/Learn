package com.thread.threadBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2024/06/13
 * @Description:
 */
public class JUCAwaitDemo {

    private Lock lock = new ReentrantLock(); //类内部定义lock，在多线程执行中，通过在方法中设置锁实现竞争访问
    private Condition conditionA = lock.newCondition();//通过condition使线程执行粒度更细

    public void before(){
        lock.lock();
        try {
            System.out.println("before");
            conditionA.signalAll();//LockSupport.unpark(node.thread);唤醒阻塞队列中的一个线程，使其继续执行
        }finally {
            lock.unlock();
        }
    }

    public void after(){
        lock.lock();
        try {
            System.out.println("begin");
            conditionA.await(); //底层通过LockSupport.park(this)方法将该线程挂起，移入Condition的等待队列中
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        JUCAwaitDemo jucAwaitDemo = new JUCAwaitDemo();
        executorService.execute(jucAwaitDemo::after);
        executorService.execute(jucAwaitDemo::before);
        executorService.shutdown();
    }
}
