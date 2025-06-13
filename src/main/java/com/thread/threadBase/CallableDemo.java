package com.thread.threadBase;

import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: LQL
 * @Date: 2025/05/28
 * @Description:
 */
public class CallableDemo implements Callable<Future> {

    @Override
    public Future call() throws Exception {
        return new AsyncResult<>("alen");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {return "bella";};
        FutureTask futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(thread.getState());
        System.out.println(futureTask.get());
    }

}
