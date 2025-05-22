package com.thread.threadBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LQL
 * @Date: 2024/06/04
 * @Description:
 */
public class ThreadPoolForExecutor {


    /**
     * 创建线程池可以通过executors的三种方法分别创建缓存线程池，固定数量线程池，单个线程线程池
     *
     * @param args
     */
    public static void main(String[] args) {
//        Executors.newCachedThreadPool()
        System.out.println("cpu core is :  " + Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.
                newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().availableProcessors());
        Thread thread = new Thread(() -> {
            System.out.println("end");
        }, "alen");
        System.out.println(thread.getName());
        executorService.execute(thread);
        executorService.shutdown();
    }

}
