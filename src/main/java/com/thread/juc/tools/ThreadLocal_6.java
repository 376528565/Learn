package com.thread.juc.tools;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: LQL
 * @Date: 2024/07/18
 * @Description:
 */
public class ThreadLocal_6 {

    /**
     * ThreadLocal是通过线程隔离的方式防止任务在共享资源上产生冲突,
     * 线程本地存储是一种自动化机制，可以为使用相同变量的每个不同线程都创建不同的存储
     */

    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };



    public static void main(String[] args) {
//        ThreadLocal
//        new ThreadPoolExecutor()
        System.out.println(ThreadLocal_6.df.get().format(new Date()));

    }

}
