package com.thread.juc.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: LQL
 * @Date: 2024/07/15
 * @Description:
 */
public class FutureTask_1 {

    private class CallableDemo implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return String.valueOf(Math.random());
        }
    }

    /**
     * Future 表示了一个任务的生命周期，是一个可取消的异步运算，可以把它看作是一个异步操作的结果的占位符，
     * 它将在未来的某个时刻完成，并提供对其结果的访问。
     * 在并发包中许多异步任务类都继承自Future，其中最典型的就是 FutureTask
     *
     * Q:
     * FutureTask用来解决什么问题的? 为什么会出现?
     * A:FutureTask 用来解决在多线程并发环境中异步执行任务并获取结果的问题。
     * 它允许我们提交任务给线程池或独立线程执行，并且可以通过 get() 方法获取任务的执行结果，
     * 支持任务的取消和状态查询，是一种简化异步任务处理的工具
     *
     * FutureTask类结构关系怎么样的?
     * A:FutureTask 实现了 RunnableFuture 接口，
     * 而 RunnableFuture 接口继承了 Runnable 和 Future 接口。
     * 因此，FutureTask 既可以作为 Runnable 被 Thread 直接调用，
     * 又可以使用 Future 中对任务执行结果的获取、任务状态的获取、取消任务等功能
     *
     * FutureTask的线程安全是由什么保证的?
     * A:FutureTask 的线程安全性主要是通过 Unsafe 类的 CAS（Compare-And-Swap）操作来保证的。
     * 这种无锁的原子操作确保了在多线程环境下对关键状态的安全更新。
     * 此外，FutureTask 还使用了 volatile 关键字和内部锁机制来进一步保证线程安全
     *
     * FutureTask结果返回机制?
     * A:在任务执行结束或执行出现异常时，FutureTask 会返回结果或抛出相应的异常。
     * 调用 FutureTask 的 cancel 方法也会导致任务抛出 CancellationException。
     *
     * FutureTask内部运行状态的转变?
     * A:FutureTask 内部的状态共有七种，
     * 分别是：NEW（新任务）、COMPLETING（任务执行中或完成但结果未存储）、
     * NORMAL（成功完成）、EXCEPTIONAL（执行中出现异常）、CANCELLED（任务取消，无中断）、
     * INTERRUPTING（任务取消，进行中断）、INTERRUPTED（任务已被中断）。
     * 这些状态通过 volatile 变量和 CAS 操作来保证线程安全性
     * 其中：
     * 1、INTERRUPTING：当任务调用 cancel(true) 方法时，如果当前线程还没有执行或者正在执行，
     * 状态变为 INTERRUPTING。此状态表示任务正在被取消，并且正在进行中断操作
     * 2、INTERRUPTED (6): 在 INTERRUPTING 状态下，调用任务的 Thread.interrupt() 方法后，
     * 状态变为 INTERRUPTED。此状态表示任务已经被取消并且中断操作已经完成
     *
     * FutureTask通常会怎么用? 举例说明
     * A:
     * 1、结合线程池：创建 FutureTask 集合，通过重写 Callable 的 call 方法实现多线程异步并发，
     * 将 FutureTask 提交给线程池执行
     * 2、直接使用线程：通过 FutureTask 创建任务（可以是 Runnable 或 Callable），
     * 通过创建 Thread 实例并调用 start 方法实现多线程异步调用
     */

    public void deal() {
//        FutureTask
        System.out.println(Runtime.getRuntime().availableProcessors());
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<FutureTask<String>> futureTasks = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            FutureTask<String> futureTask = new FutureTask<>(new CallableDemo());
            futureTasks.add(futureTask);
            executorService.submit(futureTask);
        }
        for (FutureTask<String> futureTask : futureTasks){
            try {
                System.out.println(futureTask.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        System.out.println("deal time is :" + (System.currentTimeMillis() - startTime));
    }

    public void func1(){
        FutureTask<String> futureTask = new FutureTask<>(()->{
            return "alen";
        });
        try {
            Thread thread = new Thread(futureTask);
            thread.start();
            System.out.println(futureTask.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new FutureTask_1().func1();
    }


}

