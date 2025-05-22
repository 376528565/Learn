package com.thread.juc.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: LQL
 * @Date: 2024/06/24
 * @Description:
 */
public class ReentrantReadWriteLock_4 {

    /**
     * ReentrantReadWriteLock表示可重入读写锁，ReentrantReadWriteLock中包含了两种锁，
     * 读锁ReadLock和写锁WriteLock，可以通过这两种锁实现线程间的同步
     * Q:
     * 为什么有了ReentrantLock还需要ReentrantReadWriteLock?
     * rl排他锁，多使用在读写均衡或者写锁较多的场景下
     * 而rrwl多使用在读锁较多的场景下
     *
     * ReentrantReadWriteLock底层实现原理?
     * 主要依赖AQS，结构包括-Sync继承AQS，FairSync和NonFairSync继承Sync实现公平非公平锁
     * ReadLock/WriteLock读写锁，通过调用sync的共享和排他锁实现
     *
     * ReentrantReadWriteLock底层读写状态如何设计的? 高16位为读锁，低16位为写锁
     * 高16位为读锁，低16位为写锁
     *
     * 读锁和写锁的最大数量是多少?
     * 65535（2*16 - 1）
     *
     * 本地线程计数器ThreadLocalHoldCounter是用来做什么的?
     *  给每个线程存储当前线程获取读锁的次数（重入）
     *
     * 缓存计数器HoldCounter是用来做什么的?
     *  记录线程获取读锁的次数，threadLocalHoldCounter内部的实现就是通过创建HoldCounter实例实现的
     *
     * 写锁的获取与释放是怎么实现的?
     * 获取锁：
     *  1、判断当前锁是否已被占用：在尝试获取写锁时，首先检查当前锁的状态。
     *  如果锁已经被其他线程占用（即锁的状态不为零），则会进一步判断
     *  2、判断当前线程是否持有锁：如果锁是可重入的（同一个线程可以多次获取写锁），
     *  那么如果当前线程已经持有锁，则增加重入计数并成功获取锁
     *  3、公平锁和非公平锁的处理：
     *  公平锁：在公平锁的情况下，线程会根据等待的顺序获取锁，即先到先得。如果有其他线程在等待获取锁，当前线程会进入等待队列
     *  非公平锁：在非公平锁的情况下，当前线程会尝试插队获取锁。如果锁没有被占用，当前线程直接获取锁；如果锁被占用，当前线程会进入等待队列
     *  释放锁：
     *  1、判断当前线程是否持有锁：在尝试释放写锁时，首先检查是否是当前线程持有锁。
     *  如果不是当前线程持有锁，会抛出异常（IllegalMonitorStateException）
     *  2、减少重入计数：如果是当前线程持有锁，减少重入计数。如果重入计数减少到零，表示完全释放锁
     *  3、唤醒等待线程：完全释放锁后，尝试唤醒在等待队列中的下一个线程，使其有机会获取锁
     *
     * 读锁的获取与释放是怎么实现的?
     *  获取锁：
     *  1、校验获取读锁的线程数有没有达到最大值：
     * 每个线程可以多次获取读锁，但所有线程共享的读锁计数不能超过一个最大值 MAX_COUNT
     * 2、获取当前锁的状态：
     * 获取当前锁的状态并检查是否有写锁被持有。
     * 3、判断是否当前线程持有写锁：
     * 如果当前线程持有写锁，可以允许其获取读锁（重入读锁）
     * 4、读锁是否可重入：
     * 如果当前线程已经持有读锁，则增加该线程的读锁计数（HoldCounter）
     * 5、公平锁和非公平锁的处理：
     * 公平锁：如果是公平锁，当前线程会按顺序获取读锁，如果有其他线程在等待，当前线程会进入等待队列。
     * 非公平锁：如果是非公平锁，当前线程会尝试插队获取读锁。如果没有写锁被持有，直接获取读锁；否则，当前线程会进入等待队列
     * 释放锁：
     * 1、判断当前线程是否持有读锁：
     * 获取当前线程的 HoldCounter 并减少计数。
     * 2、减少重入计数：
     * 如果 HoldCounter 的计数减少到零，表示完全释放读锁，移除当前线程的 HoldCounter
     * 3、唤醒等待线程：
     * 如果所有读锁都被释放，唤醒在等待队列中的下一个线程，使其有机会获取锁
     *
     * RentrantReadWriteLock为什么不支持锁升级?
     * 1、数据一致性问题：
     * 读锁允许多个线程同时获取，这些线程可以同时读取数据。如果其中一个线程尝试将其读锁升级为写锁，
     * 那么在它等待写锁的过程中，其他持有读锁的线程仍然可以继续读取数据。
     * 当一个线程升级到写锁时，它需要独占访问权限，但其他持有读锁的线程仍在运行，可能会导致数据的不一致
     * 2、死锁风险：
     * 假设多个线程持有读锁，并且所有这些线程都试图升级到写锁，
     * 这将导致死锁情况，因为每个线程都在等待其他线程释放读锁，而其他线程也在等待写锁。
     *
     * 什么是锁的升降级?
     *  1、无锁-偏向锁-轻量级锁-重量级锁
     *  锁降级：写锁-读锁，虽然也有读锁到写锁的锁升级，但是考虑到数据一致性、避免死锁的风险一般不支持升级
     *  锁降级时：线程在获取写锁的前提下重入获取读锁，释放写锁，处理数据，释放读锁：
     *  锁降级通常是安全的，因为写锁本身是独占的，持有写锁的线程在降级为读锁时，确保了数据的一致性。此外，锁降级不会引入死锁风险
     */

    public static void main(String[] args) {
        ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();
        ReadLock readLock1 = new ReadLock(rrwLock);
        WriteLock writeLock1 = new WriteLock(rrwLock);
        Thread thread1 = new Thread(readLock1,"a");
        Thread thread2 = new Thread(readLock1,"b");
        Thread thread3 = new Thread(writeLock1,"c");
        Thread thread4 = new Thread(writeLock1,"d");
//        读锁并发执行，写锁排他执行
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }



}
class ReadLock implements Runnable{
    private ReentrantReadWriteLock rrwLock;

    public ReadLock(ReentrantReadWriteLock reentrantReadWriteLock){
        this.rrwLock = reentrantReadWriteLock;
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            rrwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " deal");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end");
            System.out.println(System.currentTimeMillis() - startTime + " millis");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rrwLock.readLock().unlock();
        }
    }
}

class WriteLock implements Runnable{
    private ReentrantReadWriteLock rrwLock;

    public WriteLock(ReentrantReadWriteLock reentrantReadWriteLock){
        this.rrwLock = reentrantReadWriteLock;
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            rrwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " deal");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end");
            System.out.println(System.currentTimeMillis() - startTime + " millis");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rrwLock.writeLock().unlock();
        }
    }
}
