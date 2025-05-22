package com.designPattern.structure.decorator.demo2;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
public class BasicNotify implements Notify{
    @Override
    public void sendNotify() {
        System.out.println("basic send msg...");
    }
}
