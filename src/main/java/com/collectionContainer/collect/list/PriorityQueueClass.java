package com.collectionContainer.collect.list;

import java.util.PriorityQueue;

/**
 * @Author: LQL
 * @Date: 2024/12/16
 * @Description:
 */
public class PriorityQueueClass {

    /**
     * 通过引用类型的CompareTo方法判断数组中数据的大小，从而实现优先队列,较小的优先级高---
     * 通过完全二叉树实现-小根堆实现
     * private void siftUpUsingComparator(int k, E x) {  k:数组size+1，x待添加数据
     *         while (k > 0) {
     *             int parent = (k - 1) >>> 1;  //获取父节点下标
     *             Object e = queue[parent];
     *             if (comparator.compare(x, (E) e) >= 0)
     *                 break;
     *             queue[k] = e;   //未找到位置时，父节点数据后移
     *             k = parent;
     *         }
     *         queue[k] = x;
     *     }
     * 获取、移除数据的方法有两类：element()和peek()、remove()和poll()
     * 两者的区别是 前者获取不到数据时抛出异常，后者返回null
     */

    public static void main(String[] args) {
        PriorityQueue<String> objects = new PriorityQueue<>();
        objects.add("alen");
        String element1 = objects.remove();
        objects.poll();
        String element = element1;
        objects.remove("alen");
        System.out.println(5 >>> 1);
    }

}
