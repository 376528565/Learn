package com.designPattern.structure.decorator.demo1;

/**
 * @Author: LQL
 * @Date: 2025/03/31
 * @Description:
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        NotifyDecorator notifyDecorator = new NotifyDecorator(new QQNotify(new EMSNotify(new BasicNotify())));
        notifyDecorator.sendMSG();
    }

}
