package com.base.Interface;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
public class Demo1Impl implements Demo1Interface{
    @Override
    public void deal(String data) {
        System.out.println("abstract deal data: " + data);
    }

    @Override
    public void deal2(String data) {
        System.out.println("重写接口默认方法：" + data);
    }
}
