package com.designPattern.structure.decorator.demo2;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        DecoratorNotify decoratorNotify = new DecoratorNotify(new QQNotify(new EMSNotify(new BasicNotify())));
        decoratorNotify.sendNotify();
    }

}
