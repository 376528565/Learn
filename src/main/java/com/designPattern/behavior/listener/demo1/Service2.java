package com.designPattern.behavior.listener.demo1;

/**
 * @Author: LQL
 * @Date: 2025/02/08
 * @Description:
 */
public class Service2 implements ListenerService{
    @Override
    public void deal(String data) {
        System.out.println("service2 deal data: " + data);
    }
}
