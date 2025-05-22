package com.thread.juc.tools;

import java.util.concurrent.Exchanger;

/**
 * @Author: LQL
 * @Date: 2024/07/18
 * @Description:
 */
public class Exchanger_5 {

    /**
     * Exchanger是用于线程协作的工具类, 主要用于两个线程之间的数据交换
     *
     * Exchanger用于进行两个线程之间的数据交换。它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
     * 这两个线程通过exchange()方法交换数据，当一个线程先执行exchange()方法后，
     * 它会一直等待第二个线程也执行exchange()方法，当这两个线程到达同步点时，这两个线程就可以交换数据了
     *
     */

    public static void main(String[] args) {
//        Exchanger
    }

}
