package com.base.localCache;
import org.ehcache.core.Ehcache;

import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: LQL
 * @Date: 2024/11/21
 * @Description: 本地缓存在进程执行中存储数据，共多线程共享数据
 */
public class LocalCache {


    /**
     * 相比redis，本地缓存的优势在于数据直接存储在JVM的内存中，读写数据的效率相比与redis更高
     * 高频访问、低数据量、单节点应用场景中确实具有性能优势，尤其是在对数据读取效率要求极高的情况下。
     * 但在分布式、需要数据一致性或支持大数据量缓存时，Redis 更为适合
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

    }

    public static void func1(String data){
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        System.out.println(Thread.currentThread() + " func1 get data is : " + data);
        System.out.println("localThread data is : " + threadLocal1.get());
    }

}
