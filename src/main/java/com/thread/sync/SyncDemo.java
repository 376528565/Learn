package com.thread.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: LQL
 * @Date: 2024/09/23
 * @Description:
 */
public class SyncDemo {

    private static volatile CountDownLatch countDownLatch;

    /**
     * synchronized锁方法时，同一个类实例多线程会出现锁竞争
     */
    public synchronized void sync1(){
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
            System.out.println(threadName + " sleep 2 S");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * synchronized锁类时，无论是同一个实例对象还是多个实例对象，多线程中都会锁竞争
     */
    public void sync2(){
        String threadName = Thread.currentThread().getName();
        synchronized (SyncDemo.class){
            try {
                Thread.sleep(2000);
                System.out.println(threadName + " sleep 2 S");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        SyncDemo syncDemo = new SyncDemo();
        SyncDemo syncDemo1 = new SyncDemo();
        long startTime = System.currentTimeMillis();
        countDownLatch = new CountDownLatch(2);
        Thread thread = new Thread(syncDemo::sync1, "thread1");
        Thread thread1 = new Thread(syncDemo::sync1, "thread2");
        thread.start();
        thread1.start();
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - startTime);

    }

}
