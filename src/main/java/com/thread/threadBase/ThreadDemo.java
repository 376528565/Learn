package com.thread.threadBase;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LQL
 * @Date: 2025/02/18
 * @Description: CountDownLatch 实现多线程并发执行
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("deal data...");
                countDownLatch.countDown();
            }
        }));
        executorService.submit(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("deal1 data...");
                countDownLatch.countDown();
            }
        }));
        executorService.shutdown();
        countDownLatch.await();
        System.out.println("main thead deal...");
    }

}
