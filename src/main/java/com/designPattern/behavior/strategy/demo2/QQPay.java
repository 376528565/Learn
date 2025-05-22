package com.designPattern.behavior.strategy.demo2;

/**
 * @Author: LQL
 * @Date: 2024/12/24
 * @Description:
 */
public class QQPay implements Pay{
    @Override
    public void payA(String data) {
        System.out.println("qq pay : " + data);
    }
}
