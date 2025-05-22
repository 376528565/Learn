package com.thread.threadBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LQL
 * @Date: 2024/06/13
 * @Description:
 */
public class ObjectWaitDemo {


    /**
     * wait和notifyall是object类中的一部分，用在同步方法或者同步代码块中，用于控制线程的执行顺序
     * 使用wait和notifyAll让线程挂起，释放锁
     */


    public synchronized void before(){
        System.out.println("before");
        notifyAll(); //唤醒等待队列的线程
        System.out.println("end");
    }

    public synchronized void after(){
        try {
            System.out.println("begin");
            wait();  //当前线程阻塞，等待
            System.out.println("awaken");
            Thread.sleep(2000);
            System.out.println("sleep 2S");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ObjectWaitDemo objectWaitDemo = new ObjectWaitDemo();
        //多线程并发执行
        executorService.execute(objectWaitDemo::after);
        executorService.execute(objectWaitDemo::before);
        executorService.shutdown();
    }

}
