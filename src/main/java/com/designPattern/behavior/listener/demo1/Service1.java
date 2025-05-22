package com.designPattern.behavior.listener.demo1;

/**
 * @Author: LQL
 * @Date: 2025/02/08
 * @Description:
 */
public class Service1 implements ListenerService{
    @Override
    public void deal(String data) {
        System.out.println("service1 deal data: " + data);
    }
}
