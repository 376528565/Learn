package com.designPattern.behavior.strategy.demo1;

/**
 * @Author: LQL
 * @Date: 2025/02/27
 * @Description:
 */
public class A1ServiceImpl implements AService{
    @Override
    public void deal(String data) {
        System.out.println("a1 deal service...");
    }
}
