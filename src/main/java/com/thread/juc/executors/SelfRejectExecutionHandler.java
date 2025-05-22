package com.thread.juc.executors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: LQL
 * @Date: 2024/07/16
 * @Description:
 */
public class SelfRejectExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("活跃线程数：" + executor.getActiveCount());
        System.out.println(r.toString() + "is rejected");
    }
}
