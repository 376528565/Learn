package com.thread.threadBase;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2024/11/04
 * @Description:
 */
public class SyncDemo1 {

    /**
     * 多线程如何确保线程执行顺序，可以通过synchronized或者lock实现（悲观锁方式）
     * lock方式采用公平锁方式,只需要限制某个线程获取锁，在该方法内部顺序访问其他方法，即可实现方法的顺序执行
     */
    private final ReentrantLock lock = new ReentrantLock();
    //Condition是lock提供的在不同线程直线保持通讯的方式，通过其可以实现多线程之间执行顺序一致
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    private int flag = 0;

    public void put(){
        lock.lock();
        try {
            while (flag == 3){
                System.out.println("put await....");
                conditionA.await();
            }
            flag++;
            System.out.println("wake consume...");
            conditionB.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try {
            while (flag == 0){
                System.out.println("consume await....");
                conditionB.await();
            }
            flag--;
            System.out.println("awake put....");
            conditionA.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }


    public void show1(){
        lock.lock();
        try {
            for (int i = 1; i< 3; i++){
                Thread.sleep(100 * i);
                System.out.println(Thread.currentThread().getName() + " sleep " + i * 100 +"ms");
            }
            this.show2();
        } catch (InterruptedException e) {
            System.out.println("show1，线程终端异常： " + e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    public void show2(){
        System.out.println(Thread.currentThread().getName() + " deal show2");
    }

    public static void main(String[] args) throws InterruptedException {
        SyncDemo1 syncDemo1 = new SyncDemo1();
        Thread thread = new Thread(syncDemo1::put, "alen");
        Thread thread1 = new Thread(syncDemo1::consume, "bella");
        thread.start();
        thread1.start();
        thread1.join();
        thread.join();
        System.out.println("main thread deal....");
//        Thread thread1 = new Thread(syncDemo1::show1, "alen");
//        Thread thread2 = new Thread(syncDemo1::show1, "bella");
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println("main thread deal...");
    }
}
