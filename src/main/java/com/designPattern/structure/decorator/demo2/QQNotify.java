package com.designPattern.structure.decorator.demo2;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
public class QQNotify extends DecoratorNotify{


    public QQNotify(Notify notify) {
        super(notify);
    }

    @Override
    public void sendNotify() {
        super.sendNotify();
        System.out.println("qq send msg");
    }
}
