package com.designPattern.structure.decorator.demo1;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class BasicNotify implements Notify{
    @Override
    public void sendMSG() {
        System.out.println("basic notify...");
    }
}
