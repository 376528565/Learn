package com.designPattern.behavior.TemplateMethod;

/**
 * @Author: LQL
 * @Date: 2024/08/22
 * @Description:
 */
public class TemplateA extends TemplateMethodAbstract{
    @Override
    public String func1(String data) {
        System.out.println(" a func1 " + data);
        return "success";
    }

    @Override
    public String func2(String data) {
        System.out.println(" a func2 " + data);
        return "failsss";
    }
}
