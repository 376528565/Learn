package com.thread.threadBase;

/**
 * @Author: LQL
 * @Date: 2024/06/04
 * @Description:
 */
public class DaemonThread {

    private static volatile int i = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (i == 1) {
                try {
                    Thread.sleep(700);
                    System.out.println("thread" + i);
                } catch (InterruptedException e) {
                    System.out.println("user thread end");
                    throw new RuntimeException(e);
                }
            }
        });
        //守护线程一般后台循环执行，当整个进程中所有线程执行结束后，守护线程才会停止执行，最终整个进程执行结束
        thread.setDaemon(true);
        thread.start();
        System.out.println("main deal...");
        Thread.sleep(1400);
//        thread.wait();
        i = 2;
        Thread.sleep(1400);
        System.out.println("main end");
    }

}
