package com.designPattern.behavior.strategy.demo2;

/**
 * @Author: LQL
 * @Date: 2024/12/24
 * @Description:
 */
public class PayContext {

    private Pay pay;

    public PayContext(Pay pay){
        this.pay = pay;
    }

    public void execute(String data){
        System.out.println("strategy context deal!");
        this.pay.payA(data);
    }

}
