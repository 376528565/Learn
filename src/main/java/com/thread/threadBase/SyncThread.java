package com.thread.threadBase;

/**
 * @Author: LQL
 * @Date: 2024/06/04
 * @Description:
 */
public class SyncThread {

    private String name;

    public static void main(String[] args) throws InterruptedException {
        SyncThread syncThread = new SyncThread();
        Thread thread = new Thread(SyncThread::show);
        Thread thread1 = new Thread(SyncThread::show);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println("main end");
    }

    /**
     * 类锁
     */
    public static synchronized void show(){
        try {
            Thread.sleep(1000);
            System.out.println("sync show");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
