package com.thread.threadBase.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2024/09/26
 * @Description:
 */
public class LockCondition {

    // ReentrantLock(true)设置为公平锁
    private final Lock lock = new ReentrantLock();

    /**
     * 通过condition实现线程的状态切换（runnable - waiting - runnable）内部是通过LockSupport(锁的基础类)
     * 实现线程的唤醒以及阻塞,从而实现多线程之间的数据同步
     * 线程6种状态：
     * new runnable blocked waiting timed-waiting terminated
     * 其中线程状态之内可以互相转换，但是线程执行结束后（terminated）就无法再通过start启动
     */
    private Condition condition1 = lock.newCondition();

    public void func1() throws InterruptedException {
        condition1.await();
    }

}
