package com.thread.juc.executors;

import java.util.concurrent.*;

/**
 * @Author: LQL
 * @Date: 2024/07/16
 * @Description:
 */
public class ThreadPoolExecutor_2 {

    /**
     * Q:
     * 为什么要有线程池?
     * A:线程池通过复用线程、控制并发、统一资源管理和监控等方式，优化了线程的使用，提高了系统的性能和稳定性。
     * 在高并发环境下，使用线程池可以有效减少资源消耗，避免频繁创建和销毁线程带来的开销，并提供监控和调优的能力
     *
     * Java是实现和管理线程池有哪些方式? 请简单举例如何使用。
     * A:
     * 1、通过Executors创建线程池
     * 2、通过ThreadPoolExecutor自定义创建线程池
     *
     * 为什么很多公司不允许使用Executors去创建线程池? 那么推荐怎么使用呢?
     * A:因为通过executor创建的线程池是存在缺陷的，可能会导致内存溢出等问题，并没有根据服务器的实际性能确定线程池参数。
     * 推荐通过ThreadPoolExecutor自定义线程池的创建
     *
     * ThreadPoolExecutor有哪些核心的配置参数?
     * A:核心线程数、最大线程数、线程存活时间、时间单位、阻塞队列、拒绝策略
     *
     * 请简要说明ThreadPoolExecutor可以创建哪是哪三种线程池呢?
     * A:固定大小线程池（Fixed Thread Pool）
     * 缓存线程池（Cached Thread Pool）
     * 单线程池（Single Thread Pool）
     *
     * 当队列满了并且worker的数量达到maxSize的时候，会怎么样?
     * A:会执行拒绝策略
     *
     * 说说ThreadPoolExecutor有哪些RejectedExecutionHandler策略? 默认是什么策略?
     * A:4种，抛出异常（默认）、不执行、使用当前线程执行、丢弃队头任务，执行当前任务
     *
     * 简要说下线程池的任务执行机制? execute –> addWorker –>runworker (getTask)
     * A:当将一个任务通过execute添加的线程池中时，
     * 如果此时线程池中线程数没有达到核心线程数，则会创建新线程直接执行，
     * 如果超过核心线程数，但是阻塞队列未满，会通过调用workQueue的offer方法将当前线程添加到队列中，
     * 然后在addworker中通过gettask方法获取workQueue中的线程执行
     *
     * 线程池中任务是如何提交的?
     * A:当调用 submit 方法时，任务首先会被封装成一个 RunnableFuture 对象（通常是 FutureTask 类的实例）。
     * 这个 RunnableFuture 对象会被传递给 ThreadPoolExecutor 的 execute 方法。
     * execute 方法会根据当前的线程池状态和任务队列状态来决定如何处理这个任务，可能会立即执行、放入阻塞队列或者创建新线程来执行
     *
     * 线程池中任务是如何关闭的?
     * A:使用 shutdown 方法来优雅地关闭线程池，允许已提交的任务执行完成，不影响阻塞队列中的任务。
     * 使用 shutdownNow 方法来强制关闭线程池，试图中断正在执行的任务，并返回未执行的任务列表
     *
     * 在配置线程池的时候需要考虑哪些配置因素?
     * A:
     * 1、考虑是CPU密集型还是IO，确定最大线程数分别是CPU核数+1 以及核数的2倍
     * 2、考虑任务的优先级和响应时间需求：例如通过设置合适的拒绝策略来处理超出负载的情况
     * 3、内存和资源限制：线程池的配置应考虑到系统的内存和其他资源限制，避免创建过多线程导致资源耗尽或竞争
     *
     * 如何监控线程池的状态
     * A:
     * getTaskCount：获取线程池曾经提交过的任务总数，包括已经完成的和正在执行的任务。-这有助于了解线程池的工作负载
     * getCompletedTaskCount：获取线程池已完成的任务总数。
     * 通过对比 getTaskCount 和 getCompletedTaskCount 的结果，可以计算出仍在执行或等待执行的任务数量
     * getLargestPoolSize：获取线程池曾经达到过的最大线程数。-这可以用来了解线程池在高峰期的最大并发线程数。
     * getPoolSize：获取当前线程池中的线程数，包括活动线程和空闲线程。-这帮助你了解线程池的当前规模
     * getActiveCount：获取当前线程池中正在执行任务的线程数-通过这项指标可以了解当前有多少线程正在处理任务，反映线程池的活动状态。
     * getQueue：获取阻塞队列，可以通过 getQueue().size() 来获取当前等待执行的任务数（这有助于了解线程池的等待队列情况，是否有大量任务在等待执行）
     */

    public static void main(String[] args) throws InterruptedException {
//        Executors.newFixedThreadPool()
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), threadFactory, new SelfRejectExecutionHandler());
        for (int i = 0; i < 10; i++){
            int finalI = i;
            threadPoolExecutor.execute(new Thread(()->{
                try {
                    Thread.sleep(finalI * 100);
                    System.out.println(finalI + " deal");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        Thread.sleep(10000);
        System.out.println("main deal");
        threadPoolExecutor.shutdown();
//        System.out.println(Integer.SIZE);
    }
}
