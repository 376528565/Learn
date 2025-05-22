package com.thread.juc;

import com.thread.util.enumUtil.ThreadInfoEnum;

/**
 * @Author: LQL
 * @Date: 2024/06/28
 * @Description: 用于创建线程局部变量的类，它使得每个线程都拥有独立的变量副本，
 * 从而避免了多线程环境下的变量共享问题，提供了线程隔离的能力
 */
public class TheadLocalDemo {

    private static final ThreadLocal<Integer> threadLockValue = ThreadLocal.withInitial(()-> 0);
//    private static final String MAIN_THREAD_NAME = "alen";

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(threadLockValue.get());
            threadLockValue.set(threadLockValue.get() + ThreadInfoEnum.getValueByThreadName(Thread.currentThread().getName()));
            System.out.println(Thread.currentThread().getName() + threadLockValue.get());
        };
        Thread thread = new Thread(runnable,"alen");
        Thread thread1 = new Thread(runnable,"zye");
        thread.start();
        thread1.start();

    }

}
