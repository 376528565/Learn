package com.thread.volatileDemo;

/**
 * @Author: LQL
 * @Date: 2024/06/17
 * @Description:
 */
public class VolatileNote {

    /**
     * volatile关键字的作用是什么?
     * A:保证内存可见性、禁止指令重排序，保证单次原子性操作
     * volatile能保证原子性吗?之前32位机器上共享的long和double变量的为什么要用volatile?
     * A:可以保证单次原子性操作，因为long和double是8个字节占64位，因此其高32和低32位两部分进行数据处理，读写可能不是原子性的
     * 现在64位机器上是否也要设置呢?
     * A；不需要，因为目前64位机器已经自动实现了64位读写的原子性
     * i++为什么不能保证原子性?
     * A；i++包含三步骤：1、获取i的值，2、值+1，3、将i的值写回内存
     * volatile是如何实现可见性的?
     * A；通过内存屏障（memory barrier）内存屏障，又称内存栅栏，是一个 CPU 指令。如果一个线程在工作内存中对共享变量进行修改
     * 那么CPU会将该共享变量的值写回主内存，并将其他线程上的该值设置失效，其他线程重新获取该值
     * 内存屏障。volatile是如何实现有序性的?happens-before等
     * A；volatile变量的写发生在读前
     * 说下volatile的应用场景?
     * A；状态标志、单例
     * 1、对变量的写操作不依赖于当前值。
     * 2、该变量没有包含在具有其他变量的不变式中。
     * 3、只有在状态真正独立于程序内其他内容时才能使用 volatile
     */

}
