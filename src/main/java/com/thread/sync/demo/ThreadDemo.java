package com.thread.sync.demo;

/**
 * @Author: LQL
 * @Date: 2025/04/14
 * @Description:
 */
public class ThreadDemo {



    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo1 = new ThreadDemo();
        ThreadDemo threadDemo = new ThreadDemo();

        Thread thread = new Thread(()-> threadDemo.deal1("alen"), "alen");
        Thread thread2 = new Thread(()-> threadDemo1.deal2("bella"), "bella");
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("main deal...");
    }

    public synchronized void deal1(String str) {
        System.out.println(Thread.currentThread().getName() + " deal data : " + str);
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " deal end...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void deal3(String str) {
        System.out.println(Thread.currentThread().getName() + " deal data : " + str);
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " deal end...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deal2(String data){
        System.out.println(Thread.currentThread().getName() + " deal data: " + data);
        synchronized (ThreadDemo.class){
            System.out.println("sync class deal...");
            System.out.println(Thread.currentThread().getName() + "....");
        }
    }

}
