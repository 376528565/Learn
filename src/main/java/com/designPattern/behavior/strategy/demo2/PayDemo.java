package com.designPattern.behavior.strategy.demo2;

/**
 * @Author: LQL
 * @Date: 2024/12/24
 * @Description:
 */
public class PayDemo {

    public static void main(String[] args) {
        Pay qqPay = new QQPay();
        PayContext payContext = new PayContext(qqPay);
        payContext.execute("alen");
    }

}
