package com.base.Interface;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
public class Demo2Impl implements Demo1Interface,Demo2Interface{
    @Override
    public void deal(String data) {
        System.out.println("demo1 deal...");
    }

    @Override
    public void deal3() {
        System.out.println("demo2 deal3...");
    }
}
