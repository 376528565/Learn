package com.thread.volatileDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    /**
     * volatile并不能保证原子性
     * 只能保证单次读、写的原子性
     * i++为什么不能保证原子性？：i++包含两个步骤，读和写:1、读取i的值，2、i值加1 3、赋值给i
     * 共享的double和long变量为什么用volatile？
     * double和long占用8个字节，这两种数据类型的操作分为高32和低32位两部分，因此对于普通的long和double在读和写时
     * 可能不是原子性的。
     * 注意：目前各种平台下的商用虚拟机都选择把 64 位数据的读写操作作为原子操作来对待，
     * 因此我们在编写代码时一般不把long 和 double 变量专门声明为 volatile多数情况下也是不会错的
     */

    private volatile AtomicInteger i;

    public void addI() {
        i.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicDemo atomicDemo = new AtomicDemo();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int n = 0; n < 100; n++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                atomicDemo.addI();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(atomicDemo.i);
    }
}