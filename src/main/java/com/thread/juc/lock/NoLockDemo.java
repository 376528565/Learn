package com.thread.juc.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LQL
 * @Date: 2024/06/17
 * @Description: 解释无锁多线程处理,多线程访问无共享数据的方法或者类是，无需做线程安全处理
 */
public class NoLockDemo {

    public void func1(){
        int count = 1;
        for (int i = 0; i < 100; i++)
            count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        NoLockDemo noLockDemo = new NoLockDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.execute(noLockDemo::func1);
        executorService.execute(noLockDemo::func1);
        executorService.shutdown();
    }

}
