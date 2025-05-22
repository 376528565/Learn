package com.base.fanxing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
public class FanXingNote {

    /**
     * 泛型有三种使用方式，分别为：泛型类、泛型接口、泛型方法
     * FX<T extends E>:T继承E类，则T只能是E以及E的子类，extends决定泛型上限  常用
     * FX<T super E>:T只接受E类以及父类为E的类，super决定泛型下限 不常用
     */

    /**
     * 静态内部泛型类
     * @param <K>
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class A<K,V>{
        private K key;
        private V value;
        private static final int INIT_SIZE = 10;
        private Node<K,V>[] a = new Node[INIT_SIZE];
        private int size = 0;

       @AllArgsConstructor
        static class Node<K,V>{
            private K key;
            private V value;
            private Node<K,V> next;
        }

        public void put(K key, V value){
            int index = String.valueOf(key).hashCode();
            Node<K, V> node = a[index % INIT_SIZE];
            while (null != node & !node.key.equals(key)){

            }
        }
    }

    public static void main(String[] args) {
        A<String,Integer> a = new A<>();
        a.setKey("alen");
        a.setValue(23);
        System.out.println(a.getKey() + "  " + a.getValue());
    }

}
