package com.thread.volatileDemo;

public class MemoryVisibility {

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(()->{
            while (!flag){

            }
            System.out.println("inner thread end");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "end");
        //主线程1秒后将flag值修改为true，但是子线程仍然在loop（循环），证明多线程的内存不可见性
        //即每个线程都有高速缓存-称为工作内存，只对该线程可见
        flag = true;
    }

}
