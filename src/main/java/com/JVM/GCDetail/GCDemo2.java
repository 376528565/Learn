package com.JVM.GCDetail;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: LQL
 * @Date: 2024/11/01
 * @Description: 模拟GC作为守护线程对内存数据进行处理
 */
public class GCDemo2 {

    //确保数据一致性
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(() -> {
            try {
                while (true){
                    atomicCount.incrementAndGet();
                    System.out.println("user thread count is : " + atomicCount.get());
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("user thread interrupt");
            }
        });

        Thread gcThread = new Thread(() -> {
            try {
                while (true) {
                    if (atomicCount.get() >= 10) {
                        System.out.println("GC thread deal...");
                        atomicCount.set(0);
                    }
                    Thread.sleep(500);
                    System.out.println("gc check....");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("GC Thread interrupted");
            }
        });

        gcThread.setDaemon(true);
        userThread.start();
        gcThread.start();

        userThread.join();
        System.out.println("main thread deal");
    }

}
