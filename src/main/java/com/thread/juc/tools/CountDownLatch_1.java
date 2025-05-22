package com.thread.juc.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: LQL
 * @Date: 2024/07/17
 * @Description:
 */
public class CountDownLatch_1 {

    /**
     * CountDownLatch底层也是由AQS，用来同步一个或多个任务的常用并发工具类，强制它们等待由其他任务执行的一组操作完成
     * Q:
     * 什么是CountDownLatch?
     * CountDownLatch 是 java.util.concurrent 包中的一个同步辅助类，用于多个线程之间的协调。
     * 它允许一个或多个线程等待，直到在其他线程中执行的一组操作完成
     *
     * CountDownLatch底层实现原理?
     * 通过内部类sync继承AQS实现，所以其实现逻辑是借助AQS实现的共享同步队列
     * 通过await（）方法使当前线程在计数器不为0的时候等待，countdown方法使得计数器-1，并在计数器为0时唤醒所有
     * 等待的线程
     *
     * CountDownLatch一次可以唤醒几个任务? 多个
     * 醒多个，有几个线程被CountDownLatch实例await，就会唤醒几个
     *
     * CountDownLatch有哪些主要方法? await(),countDown()
     * await使当前线程等待计数器值变为0时被唤醒
     * countDown使得计数器-1
     *
     * CountDownLatch适用于什么场景?
     * CountDownLatch 非常适用于需要协调多线程之间按照步骤同步执行的场景。
     * 通过等待一组操作完成，确保某些操作在其他操作完成后再执行，从而实现线程间的协调和同步
     *
     */

    private volatile List<Integer> list = new ArrayList<>();
    public void add(int i){
        list.add(i);
    }

    public int getSize(){
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatch_1 o1 = new CountDownLatch_1();
//        使用countDownLatch实现多线程同步
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        new Thread(()->{
//            System.out.println("wait deal");
//            try {
//                if (o1.getSize() != 5){
//                    countDownLatch.await();
//                    System.out.println("wait end");
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
//
//        new Thread(()->{
//            for (int i = 0; i< 10; i++){
//                System.out.println("add : " + i);
//                o1.add(i);
//                if (o1.getSize() == 5){
//                    System.out.println("add end");
//                    countDownLatch.countDown();
//                    break;
//                }
//            }
//        }).start();


//        使用wait和notify实现线程同步
        new Thread(()->{
            System.out.println("wait deal");
            synchronized (o1){
                try {
                    if (o1.getSize() != 5){
                        o1.wait();
                        System.out.println("wait end");
//                        o1.notify();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(()->{
            System.out.println("add deal");
            synchronized (o1){
                for (int i = 0; i < 10; i++){
                    o1.add(i);
                    System.out.println("add " + i);
                    if (o1.getSize() == 5){
                        System.out.println("add end");
                        o1.notify();
                        break;
                    }
                }
            }
        }).start();


    }

}
