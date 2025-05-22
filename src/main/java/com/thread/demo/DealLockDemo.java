package com.thread.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LQL
 * @Date: 2025/05/13
 * @Description:
 */
public class DealLockDemo {

    // 静态集合保持对大对象的引用，防止被GC回收
    private static List<byte[]> memoryLeakList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("内存溢出演示程序启动...");
        System.out.println("当前JVM内存参数：");
        System.out.println("初始堆内存(Xms): " + Runtime.getRuntime().totalMemory() / 1024 + "KB");
        System.out.println("最大堆内存(Xmx): " + Runtime.getRuntime().maxMemory() / 1024 + "KB");

        try {
            // 模拟内存泄漏
            simulateMemoryLeak();
        } catch (OutOfMemoryError e) {
            System.err.println("捕获到内存溢出错误: " + e.toString());
            // 这里可以添加一些错误处理逻辑
            throw e; // 重新抛出以便生成堆转储文件
        }
    }

    /**
     * 模拟内存泄漏的方法
     */
    private static void simulateMemoryLeak() {
        int counter = 0;
        while (true) {
            try {
                // 每次分配100KB的字节数组
                byte[] data = new byte[100 * 1024]; // 100KB
                memoryLeakList.add(data);
                counter++;

                // 每10次输出一次内存信息
                if (counter % 10 == 0) {
                    System.out.printf("已分配 %d 个10KB数组，总计: %dKB%n",
                            counter, counter * 10);
                    printMemoryUsage();
                }

                // 稍微延迟一下，方便观察
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 打印当前内存使用情况
     */
    private static void printMemoryUsage() {
        long free = Runtime.getRuntime().freeMemory() / 1024;
        long total = Runtime.getRuntime().totalMemory() / 1024;
        long max = Runtime.getRuntime().maxMemory() / 1024;
        long used = total - free;

        System.out.printf("内存使用: 已用=%dKB, 空闲=%dKB, 当前堆=%dKB, 最大堆=%dKB%n",
                used, free, total, max);
    }

}
