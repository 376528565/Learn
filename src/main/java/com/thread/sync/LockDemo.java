package com.thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private final Lock lock = new ReentrantLock(true);
    /**
     * 针对lock的condition调用await和signal方法时，只有在线程获取锁时才能执行await和signal方法
     * 内部通过lockSupport的park和unPark方法实现最基础的线程wait和唤醒
     * 如果定义多个condition，每个condition单独维护一个等待队列，被唤醒时也只是当前condition队列中线程被唤醒
     */
    private Condition condition = lock.newCondition();
    public void func1(){
        String threadName = Thread.currentThread().getName();
        lock.lock();
        try {
            Thread.sleep(100);
            System.out.println(threadName + " deal something");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(threadName + " unlock");
            lock.unlock();
        }
    }

    public void func2(){
        String threadName = Thread.currentThread().getName();
        lock.lock();
        try {
            Thread.sleep(100);
            System.out.println(threadName + " deal something");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(threadName + " unlock");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo syncDemo1 = new LockDemo();
        Thread thread1 = new Thread(syncDemo1::func1,"thread1");
        Thread thread2 = new Thread(syncDemo1::func2,"thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main thread deal...");
    }


}
