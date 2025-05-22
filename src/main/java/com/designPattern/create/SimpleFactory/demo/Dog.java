package com.designPattern.create.SimpleFactory.demo;

/**
 * @Author: LQL
 * @Date: 2025/05/20
 * @Description:
 */
public class Dog implements Animal{
    @Override
    public void bark() {
        System.out.println("dog bark...");
    }
}
