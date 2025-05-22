package com.designPattern.behavior.ChainOfResponsibility.demo;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class TWONode extends CORLink{
    @Override
    public String deal(String data) {
        System.out.println("two deal...");
        return this.getNext(data);
    }
}
