package com.collectionContainer.collect.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: LQL
 * @Date: 2024/12/18
 * @Description:
 */
public class HashSetAndHashMap {

    /**
     * hashset内部实现是通过hashMap实现的,set的key时值，value是静态常量对象(new Object())
     * private static final Object PRESENT = new Object();
     *     public boolean add(E e) {
     *         return map.put(e, PRESENT)==null;
     *     }
     *
     * hashMap内部实现是通过hash表（数组）实现的，每个元素是一个Node（基础）或者TreeNode（红黑树）
     * Node链表转红黑树逻辑：当链表长度超过8时转为红黑树的TreeNode
     * hash表扩容时机：当hash表容量达到默认容量大小时（默认为16 * 0.75(负载因子)）：进行扩容（左移一位，扩容2倍）
     * 0.75(负载因子)为什么？：时间和空间效率之间取得平衡‌，提高查询效率降低hash冲突，以及避免频繁扩容
     * 红黑树？ 红黑树也是一种自平衡的二叉搜索树，较之 AVL 树，插入和删除时旋转次数更少
     *     static class Node<K,V> implements Map.Entry<K,V> {
     *         final int hash;     当前节点在hash表中的hash值
     *         final K key;         key
     *         V value;             value
     *         Node<K,V> next;      默认链表形式实现
     *     }
     *
     *
     *     static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
     *         TreeNode<K,V> parent;  // red-black tree links
     *         TreeNode<K,V> left;
     *         TreeNode<K,V> right;
     *         TreeNode<K,V> prev;    // needed to unlink next upon deletion
     *         boolean red;
     *         TreeNode(int hash, K key, V val, Node<K,V> next) {
     *             super(hash, key, val, next);
     *         }
     *     }
     *
     *
     */

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        HashSet<String> objects = new HashSet<>();
        objects.add("alen");
        Iterator<String> iterator = objects.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
