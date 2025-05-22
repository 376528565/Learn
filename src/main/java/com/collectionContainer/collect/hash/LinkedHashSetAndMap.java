package com.collectionContainer.collect.hash;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: LQL
 * @Date: 2025/03/11
 * @Description: 链式hashset和hashmap
 */
public class LinkedHashSetAndMap {

    /**
     * LinkedHashMap继承HashMap，对其中方法进行重写，在执行put（依然是Hashmap的put）时，通过重写部分方式
     * 通过上转型调用重写的方法实现数据的存储。
     * LinkedHashMap：维持原始数据的hashmap存储不变，并在类中以双向链表的形式存储数据. = HashMap+Linked List
     * 例如添加时：牵扯到数据处理、新增节点等操作时，通过LinkedHashMap重写对应接口，在实现原功能基础上扩展link存储
     *     final V putVal(int hash, K key, V value, boolean onlyIfAbsent{
     *         .....
     *         tab[i] = newNode(hash, key, value, null);
     *         。。。。
     *         afterNodeAccess(e);
     *         。。。。
     *         afterNodeInsertion(evict);
     *     }
     *
     * LinkedHashSet是对LinkedHashMap的简单包装，对LinkedHashSet的函数调用，
     * 都会转换成合适的LinkedHashMap方法，因此LinkedHashSet的实现非常简单
     *
     * LinkedHashMap经典用法：
     * LinkedHashMap除了可以保证迭代顺序外，还有一个非常有用的用法: 可以轻松实现一个采用了FIFO替换策略的缓存（put操作时）
     * LinkedHashMap有一个子类方法protected boolean removeEldestEntry(Map.Entry<K,V> eldest)，
     * 该方法的作用是告诉Map是否要删除“最老”的Entry
     *  具体是重写removeEldestEntry方法，在put操作的最后一步会调用afterNodeInsertion(evict);方法，默认evict= true，
     *  因此继承LinkedHashMap重写removeEldestEntry，可以实现一个固定大小的FIFO策略的缓存
     *  class FIFOCache<K, V> extends LinkedHashMap<K, V>{
     *     private final int cacheSize;
     *     public FIFOCache(int cacheSize){
     *         this.cacheSize = cacheSize;
     *     }
     *
     *     // 当Entry个数超过cacheSize时，删除最老的Entry
     *     @Override
     *     protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
     *        return size() > cacheSize;
     *     }
     * }
     */


    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedMap = new LinkedHashMap<>();
        linkedMap.put("alen","bella");
        Set<String> linkedHashSet = new LinkedHashSet<>();
    }

}
