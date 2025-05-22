package com.thread.juc.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Author: LQL
 * @Date: 2024/07/18
 * @Description:
 */
public class Semaphore_3 {


    /**
     * Semaphore底层是基于AbstractQueuedSynchronizer来实现的。
     * Semaphore称为计数信号量，它允许n个任务同时访问某个资源，
     * 可以将信号量看做是在向外分发使用资源的许可证，只有成功获取许可证，才能使用资源
     * Semaphore 确实可以被看作是一种资源管理器，用来控制对共享资源的访问。
     * 在多线程编程中，通过 Semaphore 可以有效地控制线程对这些共享资源的访问和分配
     * (将CPU的核数当成信号量，在线程执行时根据需求的核数分配许可证个数)
     *
     * Q:
     * 什么是Semaphore?
     * A:
     * 多线程环境下，对于线程共享资源进行管理，为线程分配对这些共享资源的许可证，实现线程对资源的访问控制
     *
     * Semaphore内部原理?
     * A;
     * 内部结构跟ReentrantLock类似，包含Sync以及继承其的公平锁和非公平锁实现，基于AQS。
     * 通过acquire以及release方法实现对同步锁state的计数管理，实现多线程同步
     *
     * Semaphore常用方法有哪些?
     * A:acquire，release，tryacquire，getavailablePermits等
     *
     * 如何实现线程同步和互斥的?
     * A:具体来说，Semaphore 使用一个内部计数器（即 state）来跟踪当前可用的许可证数量。
     * 线程通过 acquire 方法获取许可证，通过 release 方法释放许可证，从而实现对共享资源的访问控制
     *
     * Semaphore适合用在什么场景?
     * A:Semaphore 非常适合用在需要协调多个线程对有限共享资源（如数据库连接池、系统资源等）进行访问的场景
     * 具体例如：数据库连接池、限制资源访问（并发环境下限制对某些关键资源（如文件、网络端口等）的访问）
     * 实现限流（在高并发的应用中，限制请求的处理速率，以保护系统不被过载）
     * 多线程下载（控制并发下载线程的数量，避免过多的线程同时下载导致网络带宽被耗尽）
     * 流量控制（在生产者-消费者模式中，控制生产者生成任务的速率，确保消费者能及时处理任务）
     *
     * 单独使用Semaphore是不会使用到AQS的条件队列?
     * A:不会，在semaphore的state为0时，会将请求的线程放入同步队列中，
     * 当其他线程归还state时会环境同步队列中的线程执行
     *
     * Semaphore中申请令牌(acquire)、释放令牌(release)的实现?
     * A:申请时，根据创建semaphore时使用的时公平锁还是非公平锁，分别调用两种不同的实现。
     * 公平锁时，先获取当前semaphore的state值，减去申请的值，如果>0则会分配，反之会将当前线程放入同步队列。
     * 非公平锁时，前面一样，再进入同步队列前会先尝试获取锁资源，没获取到才会进入同步队列。
     * 释放资源时让state加上释放的令牌数,如果增加后有等待的线程，并且现在有足够的令牌满足它们的请求，则唤醒这些线程
     *
     * Semaphore初始化有10个令牌，11个线程同时各调用1次acquire方法，会发生什么?
     * A:有一个线程进入同步队列，其他线程正常获取许可证执行
     *
     * Semaphore初始化有10个令牌，一个线程重复调用11次acquire方法，会发生什么?
     * A:前面10次会成功，第11次时当前线程无法获取，线程进入同步队列等待
     *
     * Semaphore初始化有1个令牌，1个线程调用一次acquire方法，
     * 然后调用两次release方法，之后另外一个线程调用acquire(2)方法，此线程能够获取到足够的令牌并继续运行吗?
     * A;可以
     *
     * Semaphore初始化有2个令牌，一个线程调用1次release方法，然后一次性获取3个令牌，会获取到吗?
     * A:可以
     *
     */


    class ThreadA extends Thread{
        private Semaphore semaphore;
        private CountDownLatch countDownLatch;
        public ThreadA(String name,Semaphore semaphore,CountDownLatch countDownLatch){
            super(name);
            this.semaphore = semaphore;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            int semaphoreCount = 3;
            System.out.println(Thread.currentThread().getName() + " run");
            try {
                semaphore.acquire(semaphoreCount);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                System.out.println(Thread.currentThread().getName() + " release semaphore count");
                semaphore.release(semaphoreCount);
                countDownLatch.countDown();
            }
        }
    }



    public static void main(String[] args) {
        Semaphore_3 semaphore3 = new Semaphore_3();
        Semaphore semaphore = new Semaphore(10);
        semaphore3.func(semaphore);

    }

    public void func(Semaphore semaphore){
        int semaphoreCount = 5;
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadA threadA = new ThreadA("a", semaphore,countDownLatch);
        ThreadA threadA1 = new ThreadA("b", semaphore,countDownLatch);
        threadA.start();
        threadA1.start();
        try {
            countDownLatch.await();
            if (semaphore.tryAcquire(semaphoreCount)){
                System.out.println(Thread.currentThread().getName() + " acquire semaphore 5");
                Thread.sleep(1000);
            }else {
                System.out.println("semaphore state lt" + semaphoreCount);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println(Thread.currentThread().getName() + " release semaphore");
            semaphore.release(semaphoreCount);
            System.out.println("semaphore state : " + semaphore.availablePermits());
        }
    }

}
