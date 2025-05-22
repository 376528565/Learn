package com.thread.threadBase;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: LQL
 * @Date: 2024/06/04
 * @Description: 异步实现
 */
public class ThreadBaseDemo1 {

    private static int i = 0;

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " deal");
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println(e + Thread.currentThread().getName() + "线程中断异常");
            }
        },"alen");
        Thread thread1 = new Thread(()-> {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " deal");
            } catch (InterruptedException e) {
                System.out.println(e + Thread.currentThread().getName() + "线程中断");
            }
        },"bella");
        thread.start();
        thread.start(); //线程状态改变后不可再次执行
//        Thread.sleep(50);
//        thread1.start();
//        thread.join();
        thread1.join();
        System.out.println("main end");

    }



}
