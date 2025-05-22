package com.designPattern.behavior.TemplateMethod.demo1;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
public class T1Method extends TMethod{
    @Override
    public Boolean func1(String data) {
        System.out.println("func1 deal data : " + data);
        return true;
    }

    @Override
    public Boolean func2(String data) {
        System.out.println("func2 deal data : " + data);
        return true;
    }

    @Override
    public Boolean hook(String data) {
        System.out.println("t1 method deal data : " + data);
        return true;
    }
}
