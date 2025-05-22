package com.thread.threadBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2024/06/04
 * @Description:
 */
public class LockThread {

    //设置ReentrantLock(true)当前锁为公平锁，可以实现按照时间顺序获取锁
    private Lock lock = new ReentrantLock(true);

    public void show(){
        lock.lock();
        try {
//            lock.lockInterruptibly();
            for (int i = 0; i < 5; i++){
                System.out.println(i + Thread.currentThread().getName());
                Thread.sleep(i * 100);
            }
        } catch (InterruptedException e) {
            System.out.println(e + "线程超时中断，线程名：" + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockThread lockThread = new LockThread();
        Thread thread = new Thread(lockThread::show,"alen");
        Thread thread2 = new Thread(lockThread::show,"bella");
        thread.start();
        Thread.sleep(50);
        thread2.start();
//        Thread.sleep(200);
//        thread2.interrupt();
        thread.join();
        thread2.join();
//        Thread.sleep(1000);
        System.out.println("end");
    }

}
