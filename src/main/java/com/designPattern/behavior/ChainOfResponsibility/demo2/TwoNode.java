package com.designPattern.behavior.ChainOfResponsibility.demo2;

/**
 * @Author: LQL
 * @Date: 2024/11/07
 * @Description:
 */
public class TwoNode extends CorChain{
    @Override
    public String dealData(String data) {
        System.out.println("two node deal data : " + data);
        return this.getNext(data);
    }
}
