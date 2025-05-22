package com.collectionContainer.collect.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @Author: LQL
 * @Date: 2024/12/10
 * @Description:
 */
public class ArrayListClass {

    protected int age;
    int name;
    /**
     * arrayList 内部以数组形式进行存储，在添加时会判断长度是否超过数据长度，超过扩容实现是通过System.copyOf（native）
     * 方法实现的。扩容大小为原来大小的一半
     *
     * ArrayList实现了List接口，是顺序容器，即元素存放的数据与放进去的顺序相同，允许放入null元素，底层通过数组实现。
     * 除该类未实现同步外，其余跟Vector大致相同。每个ArrayList都有一个容量(capacity)，表示底层数组的实际大小，容器内存储元素的个数不能多于当前容量。
     * 当向容器中添加元素时，如果容量不足，容器会自动增大底层数组的大小。
     * 前面已经提过，Java泛型只是编译器提供的语法糖，所以这里的数组是一个Object数组，以便能够容纳任何类型的对象，在编译阶段转化为具体的类
     *
     * size(), isEmpty(), get(index), set()方法均能在常数时间内完成，add()方法的时间开销跟插入位置有关，addAll()方法的时间开销跟添加元素的个数成正比。
     * 其余方法大都是线性时间。为追求效率，ArrayList没有实现同步(synchronized)，如果需要多个线程并发访问，用户可以手动同步，也可使用Vector替代
     * （Vector在增删改时在关键代码部分添加synchronized类锁实现）
     *
     * 注意：
     * 1、在往ArrayList中添加大量元素时，为了避免频繁扩容可以根据数据量大小先进行扩容，通过arrayList.ensureCapacity(10); 扩容
     * 由于ensureCapacity是ArrayList的私有方法，因此在创建实例时不可用接口上转型创建
     *
     * ArrayList支持fast-fail机制，在iterate-迭代器处理数据时会报错：
     * 原理：多线程并发操作某一ArrayList时，集合会记录每次的操作modCount,在通过iterate操作集合数据时，会在next（）函数
     * 处理时判断在该线程中modCount是否相等，如果不相等会报错(ConcurrentModificationException)
     */

    public static void main(String[] args) throws InterruptedException {

        String[] strArray = new String[10];
        strArray[0] = "alen";
        for (int i = 0; i < strArray.length; i ++)
            System.out.println(strArray[i]);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("alen");
        arrayList.add("2");
        arrayList.add("bella");
        //Fast-Fail机制
        Thread thread1 = new Thread(() -> {
            Iterator<String> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next() + " thread is : " + Thread.currentThread().getName());
            }
        });

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3; i++)
                arrayList.add(String.valueOf(i));
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println("deal end ");
    }

}
