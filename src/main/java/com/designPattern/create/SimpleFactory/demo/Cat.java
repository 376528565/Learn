package com.designPattern.create.SimpleFactory.demo;

/**
 * @Author: LQL
 * @Date: 2025/05/20
 * @Description:
 */
public class Cat implements Animal{
    @Override
    public void bark() {
        System.out.println("cat bark...");
    }
}
