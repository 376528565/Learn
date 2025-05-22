package com.thread.threadBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LQL
 * @Date: 2024/06/04
 * @Description:
 */
public class ThreadPoolInterrupt {

    public static void main(String[] args) {
        ExecutorService executor = Executors.
                newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executor.execute(new Thread(()->{
            try {
                System.out.println("begin deal");
                Thread.sleep(2000);
                System.out.println("thread run");
            } catch (InterruptedException e) {
                System.out.println("deal exception");
                throw new RuntimeException(e);
            }
        }));
        executor.shutdownNow(); //线程池立即中断，正在执行线程会立即执行结束（shutdown()）
        System.out.println("main end");
    }

}
