package com.base.localCache;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LQL
 * @Date: 2024/11/22
 * @Description: 本地线程
 */
public class ThreadLocalNote {

    /**
     * 本地线程只在线程调用过程中有效
     * 注意；适当时机手动调用 ThreadLocal.remove() 清除数据，防止线程复用（如线程池）时数据残留
     * @param args
     * @throws InterruptedException
     */

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Runnable runnable = () -> {
            func1("alen " + Math.random()*100,countDownLatch);
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);

        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);

        executorService.shutdown();
        countDownLatch.await();
        threadLocal.remove();
        System.out.println("deal time is : " + (System.currentTimeMillis() - startTime));

    }

    public static void func1(String data,CountDownLatch countDownLatch){
        try {
            threadLocal.set(data);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " threadLocal data is : " +
                    threadLocal.get());
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException("func1线程中断");
        }
    }

}
