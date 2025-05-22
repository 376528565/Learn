package com.thread.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2024/06/20
 * @Description:
 */
public class LockSupport_1 {

    /**
     * 问题：
     * 1、Thread.sleep()和Object.wait()的区别？
     * sleep不会释放锁资源，而wait会，sleep必须带时间，而wait可带可不带
     * 2、Object.wait()和Condition.await()的区别?
     * Object.wait()和Condition.await()的原理是基本一致的，
     * 不同的是Condition.await()底层是调用LockSupport.park()来实现阻塞当前线程的
     * 实际上，它在阻塞当前线程之前还干了两件事，一是把当前线程添加到条件队列中，
     * 二是“完全”释放锁，也就是让state状态变量变为0，然后才是调用LockSupport.park()阻塞当前线程
     * 3、Thread.sleep()和LockSupport.park()的区别
     * 两者都不会释放线程占用的资源，sleep没法从外部唤醒，只能到时间醒来。
     * sleep本身就是一个native方法，而park调用的是unsafe类中的park的native方法
     * 4、Object.wait()和LockSupport.park()的区别
     * wait方法必须使用在sync代码块中，而park可以使用在任何地方，await和wait会释放锁资源是的当前线程阻塞挂起
     * 通过notify/all,signal/all唤醒
     */
//    public void func3(){
//        ReentrantLock reentrantLock = new ReentrantLock();
//        Condition condition1 = reentrantLock.newCondition();
//        condition1.await();
//        this.wait();
//    }


    /**
     * lockSupport是同步锁的基础类，通过他可以实现唤醒特定线程，以及阻塞线程
     *
     * LockSupport用来创建锁和其他同步类的基本线程阻塞原语。
     * 简而言之，当调用LockSupport.park时，表示当前线程将会等待，直至获得许可，
     * 当调用LockSupport.unpark时，必须把等待获得许可的线程作为参数进行传递，好让此线程继续运行
     * ------
     * 著作权归@pdai所有
     * 原文链接：https://pdai.tech/md/java/thread/java-thread-x-lock-LockSupport.html
     *
     *
     *
     * 注意点：
     * 1、可以通过LockSupport.park("bella");设定具体线程阻塞，然后通过LockSupport.unpark(threadName);唤醒
     * 2、Thread.interrupt()线程中断可以达到跟unpark一样的功能
     */

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("before park");
            LockSupport.park("alenPark");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("deal park");
//            while (!Thread.currentThread().isInterrupted()){
//                System.out.println("deal park");
//                LockSupport.park("thread park");
//
//                if (Thread.currentThread().isInterrupted()){
//                    System.out.println("thread was interrupted");
//                }
//            }
            System.out.println("after park");

        },"alen");

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("alenPark".equals(LockSupport.getBlocker(thread)))
            System.out.println("this thread is " + "alen");
        //线程中断结束 park阻塞
//        thread.interrupt();
        LockSupport.unpark(thread);
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");


    }


    public synchronized void func1(){
        try {
            System.out.println("deal wait");
            wait();
            System.out.println("wait");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void func2(){
        System.out.println("deal notifyAll");
        notifyAll();
        System.out.println("notifyAll");
    }

}
